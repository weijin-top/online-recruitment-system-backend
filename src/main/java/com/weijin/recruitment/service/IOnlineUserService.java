package com.weijin.recruitment.service;

import java.util.Set;

/**
 * 在线用户服务类
 *
 * @Author WeiJin
 * @Version 1.0
 * @Date 2025/3/26 18:16
 */
public interface IOnlineUserService {

    /**
     * 添加在线用户
     *
     * @param userId 用户id
     * @param roleId 角色id
     */
    void addOnlineUser(Integer userId, Integer roleId);

    /**
     * 移除在线用户
     *
     * @param userId 用户id
     * @param roleId 角色id
     */
    void removeOnlineUser(Integer userId, Integer roleId);

    /**
     * 根据角色id获取对应角色所有在线用户
     *
     * @param roleId 角色id
     * @return 对应角色所有在线用户
     */
    Set<Integer> getOnlineUsers(Integer roleId);
}
