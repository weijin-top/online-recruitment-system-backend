package com.weijin.recruitment.websocket;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weijin.recruitment.common.Result;
import com.weijin.recruitment.common.RoleEnum;
import com.weijin.recruitment.converter.UserConverter;
import com.weijin.recruitment.exception.AppException;
import com.weijin.recruitment.model.dto.SessionDto;
import com.weijin.recruitment.model.from.message.MessageFrom;
import com.weijin.recruitment.model.vo.message.SendMessageVo;
import com.weijin.recruitment.model.websocket.SocketSession;
import com.weijin.recruitment.service.IMessageService;
import com.weijin.recruitment.service.IOnlineUserService;
import com.weijin.recruitment.service.IUserService;
import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2025/3/22 10:50
 */
@ServerEndpoint("/websocket")
@Component
@Slf4j
public class WebsocketHandler {

    private static final ConcurrentHashMap<Integer, SocketSession> SESSION_MAP = new ConcurrentHashMap<>();
    private static IUserService userService;
    private static UserConverter userConverter;
    private static ObjectMapper objectMapper;
    private static IMessageService messageService;
    private static IOnlineUserService onlineUserService;

    @Autowired
    public void setInstance(IUserService userService, UserConverter userConverter,
                            ObjectMapper objectMapper, IMessageService messageService,
                            IOnlineUserService onlineUserService) {
        WebsocketHandler.userService = userService;
        WebsocketHandler.userConverter = userConverter;
        WebsocketHandler.objectMapper = objectMapper;
        WebsocketHandler.messageService = messageService;
        WebsocketHandler.onlineUserService = onlineUserService;
    }

    @OnOpen
    public void onOpen(Session session) {
        // 获取用户id
        Integer userId = getUserIdBySession(session);
        if (Objects.nonNull(SESSION_MAP.get(userId)) && SESSION_MAP.get(userId).getSession().isOpen()) {
            // 如果map中有该用户的session信息，就不再重复加入连接
            return;
        }
        SessionDto sessionDto = userService.queryInfoByUserId(userId);
        SocketSession socketSession = userConverter.dtoToSocketSession(sessionDto);
        socketSession.setSession(session);
        // 加入连接 放入map管理
        SESSION_MAP.put(userId, socketSession);
        // 将用户id放入redis
        // 当前用户角色id
        Integer currentRoleId = socketSession.getRoleId();
        onlineUserService.addOnlineUser(userId, currentRoleId);
        // 获取招聘者在线用户列表
        Set<Integer> onlineUsersOfRecruiter = onlineUserService.getOnlineUsers(RoleEnum.RECRUITER.getCode());
        // 获取求职者在线用户列表
        Set<Integer> onlineUsersOfSeeker = onlineUserService.getOnlineUsers(RoleEnum.SEEKER.getCode());
        // 获取所有用户响应给前端
        if (currentRoleId == 1) {
            // 求职者加入连接
            // 将所有招聘者在线用户列表发送给自己
            sendSelfOnlineUsers(session, onlineUsersOfRecruiter);
            // 再将求职者在线列表，响应给所有招聘者
            sendOtherOnlineUsers(socketSession.getRoleId(), onlineUsersOfSeeker);
        } else {
            // 招聘者加入连接
            // 将所有求职者在线用户列表发送给自己
            sendSelfOnlineUsers(session, onlineUsersOfSeeker);
            // 再将招聘者在线列表，响应给所有求职者
            sendOtherOnlineUsers(socketSession.getRoleId(), onlineUsersOfRecruiter);
        }

        log.info("[websocket消息]：用户 {} 加入连接，当前连接总数：{}", sessionDto.getName(), SESSION_MAP.size());
    }

    /**
     * 将与自己角色相同的在线用户列表发送给与自己角色不同的用户
     *
     * @param ownerRoleId 自己的角色id
     * @param onlineUsers 与自己角色相同的在线用户列表
     */
    private void sendOtherOnlineUsers(Integer ownerRoleId, Set<Integer> onlineUsers) {
        Result<Set<Integer>> result = new Result<>();
        // 响应码2001发送在线用户列表
        result.setCode(2001);
        result.setData(onlineUsers);
        result.setData(onlineUsers);
        String jsonStrOnlineUsers = null;
        try {
            jsonStrOnlineUsers = objectMapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            throw new AppException("object序列化为JSON字符串异常");
        }
        String finalJsonStrOnlineUsers = jsonStrOnlineUsers;
        SESSION_MAP.values().forEach(socket -> {
            if (Objects.nonNull(socket) && !Objects.equals(socket.getRoleId(), ownerRoleId)
                    && socket.getSession().isOpen()) {
                try {
                    // 加锁，保证同时只有一个线程在使用websocket发送信息
                    synchronized (WebsocketHandler.class) {
                        socket.getSession().getBasicRemote().sendText(finalJsonStrOnlineUsers);
                    }
                } catch (IOException e) {
                    throw new AppException("发送在线用户列表失败");
                }

            }

        });
        log.info("[websocket信息]: 发送组播信息：{}", finalJsonStrOnlineUsers);
    }

    /**
     * 将不同角色的在线用户列表发送给自己
     *
     * @param session     自己的session
     * @param onlineUsers 不同角色的在线用户列表
     */
    private void sendSelfOnlineUsers(Session session, Set<Integer> onlineUsers) {
        Result<Set<Integer>> result = new Result<>();
        // 响应码2001发送在线用户列表
        result.setCode(2001);
        result.setData(onlineUsers);
        try {
            String jsonStrOnlineUser = objectMapper.writeValueAsString(result);
            // 加锁，保证同时只有一个线程在使用websocket发送信息
            synchronized (WebsocketHandler.class) {
                session.getBasicRemote().sendText(jsonStrOnlineUser);
            }
            log.info("[websocket信息]: 发送单点信息：{}", jsonStrOnlineUser);
        } catch (Exception e) {
            throw new AppException("发送在线用户列表失败");
        }

    }

    @OnClose
    public void onClose(Session session) {
        Integer userId = getUserIdBySession(session);
        SocketSession socketSession = SESSION_MAP.get(userId);
        if (Objects.isNull(socketSession)) {
            // 获取不到直接不移除
            return;
        }
        // 断开连接从map移除
        SESSION_MAP.remove(userId);
        // 将用户id从redis中移除
        onlineUserService.removeOnlineUser(userId, socketSession.getRoleId());
        // 断开连接处理
        Integer roleId = socketSession.getRoleId();

        // 获取当前断开连接用户角色相同在线用户列表，响应给与自己不同角色的用户展示在线
        Set<Integer> onlineUsers = onlineUserService.getOnlineUsers(roleId);
        sendOtherOnlineUsers(roleId, onlineUsers);

        log.info("[websocket消息]：用户 {} 断开连接", socketSession.getName());
    }

    @OnError
    public void onError(Throwable throwable) {
        log.error("WebSocket error: {}", throwable.getMessage());
    }

    @OnMessage
    public void onMessage(Session session, String message) throws JsonProcessingException {
        // 反序列化字符串信息获取消息信息
        MessageFrom messageFrom = objectMapper.readValue(message, MessageFrom.class);
        // 将信息添加到数据中
        messageService.addMessage(messageFrom);
        // 发送给用户
        sendOneMessage(session, messageFrom);
        log.info("[websocket消息]：收到消息 {}", message);

    }

    /**
     * 发送新息给对方
     *
     * @param messageFrom 信息内容
     */
    private void sendOneMessage(Session session, MessageFrom messageFrom) {
        Integer receiverId = messageFrom.getReceiverId();
        // 获取接收放socketSession信息
        SocketSession receiverSocketSession = SESSION_MAP.get(receiverId);
        // map 没拿到socketSession信息就不发送，直接在上面收到信息处存入数据库
        if (Objects.isNull(receiverSocketSession)) {
            return;
        }
        // 获取发送方
        SocketSession senderSocketSession = SESSION_MAP.get(getUserIdBySession(session));
        // 构建发送信息对象
        SendMessageVo sendMessageVo = new SendMessageVo(senderSocketSession.getName(),
                senderSocketSession.getAvatar(), messageFrom);
        // 构建文本信息响应
        Result<SendMessageVo> result = new Result<>();
        // 响应码2000 发送文本信息
        result.setCode(2000);
        result.setData(sendMessageVo);
        String res = null;
        try {
            res = objectMapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            throw new AppException("JSON字符串序列化失败");
        }
        // 连接在线就发送
        Session receiverSession = receiverSocketSession.getSession();
        if (receiverSession.isOpen()) {
            try {
                // 加锁，保证同时只有一个线程在使用websocket发送信息
                synchronized (WebsocketHandler.class) {
                    receiverSession.getBasicRemote().sendText(res);
                }
            } catch (IOException e) {
                throw new AppException("发送单点信息失败");
            }
            log.info("[websocket信息]: 发送单点信息：{}", res);
        }
    }


    /**
     * 从session连接路径中获取userId
     *
     * @param session session
     * @return 用户id
     */
    private Integer getUserIdBySession(Session session) {
        String[] arr = session.getRequestURI().getQuery().split("=");
        return Integer.parseInt(arr[arr.length - 1]);
    }
}
