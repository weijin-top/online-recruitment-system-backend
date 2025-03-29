package com.weijin.recruitment.model.websocket;

import jakarta.websocket.Session;
import lombok.Data;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2025/3/22 11:02
 */
@Data
public class SocketSession {
    private Session session;
    /**
     * 用户id
     */
    private Integer id;
    /**
     * 角色id
     */
    private Integer roleId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 针对求职者真实姓名,招聘者则是公司简称
     */
    private String name;
    /**
     * 头像
     */
    private String avatar;

}
