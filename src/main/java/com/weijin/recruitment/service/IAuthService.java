package com.weijin.recruitment.service;

import com.weijin.recruitment.model.from.auth.LoginFrom;
import com.weijin.recruitment.model.from.user.RegisterFrom;
import com.weijin.recruitment.common.Result;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/7/2 15:33
 */
public interface IAuthService {

    /**
     * 用户登录
     *
     * @param request   request对象，用户获取sessionId
     * @param loginFrom 用户登录信息
     * @return token
     */
    Result<String> login(HttpServletRequest request, LoginFrom loginFrom);

    /**
     * 退出登录
     *
     * @param request 请求对象
     * @return 响应
     */
    Result<String> logout(HttpServletRequest request);

    /**
     * 注册用户
     *
     * @param request      request对象，用户获取sessionId
     * @param registerFrom 入参
     * @return 响应
     */
    Result<String> register(HttpServletRequest request, RegisterFrom registerFrom);

    /**
     * 获取图片验证码
     *
     * @param request  request对象，获取sessionId
     * @param response response对象，响应图片
     */
    void getCaptcha(HttpServletRequest request, HttpServletResponse response);
}
