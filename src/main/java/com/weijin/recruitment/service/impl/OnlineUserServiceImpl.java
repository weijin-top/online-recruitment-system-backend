package com.weijin.recruitment.service.impl;

import com.weijin.recruitment.service.IOnlineUserService;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 在线用户服务实现类
 *
 * @Author WeiJin
 * @Version 1.0
 * @Date 2025/3/26 18:26
 */
@Service
public class OnlineUserServiceImpl implements IOnlineUserService {

    /**
     * 求职者在线用户列表key
     */
    private static final String ONLINE_USERS_SEEKER_KEY = "online-recruitment-system-backend_online_users_seeker";
    /**
     * 招聘者在线用户列表key
     */
    private static final String ONLINE_USERS_RECRUITER_KEY = "online-recruitment-system-backend_online_users_recruiter";

    @Resource
    private RedisTemplate<String, Integer> redisTemplate;

    @Override
    public void addOnlineUser(Integer userId, Integer roleId) {
        if (roleId == 1) {
            // 求职者存放进求职在线用户列表
            redisTemplate.opsForSet().add(ONLINE_USERS_SEEKER_KEY, userId);
            // 一天没有用户登录，清空
            redisTemplate.expire(ONLINE_USERS_SEEKER_KEY, 1, TimeUnit.DAYS);
        } else {
            // 招聘者和放进招聘者在线用户列表
            redisTemplate.opsForSet().add(ONLINE_USERS_RECRUITER_KEY, userId);
            // 一天没有用户登录，清空
            redisTemplate.expire(ONLINE_USERS_RECRUITER_KEY, 1, TimeUnit.DAYS);
        }


    }

    @Override
    public void removeOnlineUser(Integer userId, Integer roleId) {
        if (roleId == 1) {
            // 求职者从求职在线用户列表移除
            redisTemplate.opsForSet().remove(ONLINE_USERS_SEEKER_KEY, userId);
        } else {
            // 招聘者从招聘者在线用户列表移除
            redisTemplate.opsForSet().remove(ONLINE_USERS_RECRUITER_KEY, userId);
        }

    }

    @Override
    public Set<Integer> getOnlineUsers(Integer roleId) {
        if (roleId == 1) {
            // 获取求职者的在线用户列表
            return redisTemplate.opsForSet().members(ONLINE_USERS_SEEKER_KEY);
        }
        // 获取招聘者的在线用列表
        return redisTemplate.opsForSet().members(ONLINE_USERS_RECRUITER_KEY);
    }
}
