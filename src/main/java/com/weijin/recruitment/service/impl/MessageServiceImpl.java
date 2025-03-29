package com.weijin.recruitment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.weijin.recruitment.common.RoleEnum;
import com.weijin.recruitment.converter.MessageConverter;
import com.weijin.recruitment.exception.AppException;
import com.weijin.recruitment.group.MessageGroup;
import com.weijin.recruitment.mapper.MessageMapper;
import com.weijin.recruitment.model.entity.Message;
import com.weijin.recruitment.model.from.message.MessageFrom;
import com.weijin.recruitment.model.vo.message.LastMessageVo;
import com.weijin.recruitment.model.vo.message.MutualMessageVo;
import com.weijin.recruitment.service.IMessageService;
import com.weijin.recruitment.utils.SecurityUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Objects;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2025/3/24 18:48
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements IMessageService {

    @Resource
    private MessageConverter messageConverter;

    @Override
    public int addMessage(@Validated(MessageGroup.SaveMessageGroup.class) MessageFrom messageFrom) {
        Message message = messageConverter.fromToEntity(messageFrom);
        int insert = baseMapper.insert(message);
        if (insert > 0) {
            return insert;
        }
        throw new AppException("聊天信息添加失败");
    }

    @Override
    public List<LastMessageVo> queryLastRecord() {
        Integer userId = SecurityUtil.getUserId();

        List<LastMessageVo> resList = null;
        if (Objects.equals(SecurityUtil.getRole(), RoleEnum.getRole(1))) {
            // 求职者获取与所有沟通过招聘者的最后一次聊天记录列表
            resList = baseMapper.selectSeekerLastRecord(userId);
        } else {
            resList = baseMapper.selectRecruiterLastRecord(userId);
        }

        return resList;
    }

    @Override
    public List<MutualMessageVo> queryMutualRecord(Integer userId) {
        // 获取自己的id
        Integer ownerId = SecurityUtil.getUserId();
        return baseMapper.selectMutualRecord(ownerId, userId);
    }

    @Override
    public int modifyMessageRead(Integer otherId) {

        // 查看是否有未读消息
        LambdaQueryWrapper<Message> queryWrapper = new LambdaQueryWrapper<Message>()
                .eq(Message::getSenderId, otherId)
                .eq(Message::getReceiverId, SecurityUtil.getUserId())
                .eq(Message::getIsRead, 0);
        Long count = baseMapper.selectCount(queryWrapper);
        // 没有未读消息，不用修改，直接返回0
        if (count == 0) {
            return 0;
        }
        LambdaUpdateWrapper<Message> updateWrapper = new LambdaUpdateWrapper<Message>()
                .set(Message::getIsRead, 1)
                .eq(Message::getSenderId, otherId)
                .eq(Message::getReceiverId, SecurityUtil.getUserId())
                .eq(Message::getIsRead, 0);
        return baseMapper.update(updateWrapper);

    }
}
