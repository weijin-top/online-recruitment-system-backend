package com.weijin.recruitment.service;

import com.weijin.recruitment.model.from.auth.LoginFrom;
import com.weijin.recruitment.model.from.user.UserFrom;
import com.weijin.recruitment.model.result.Result;
import jakarta.servlet.http.HttpServletRequest;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/7/2 15:33
 */
public interface IAuthService {

    /**
     * 用户登录
     * @param request request对象，用户获取sessionId
     * @param loginFrom 用户登录信息
     * @return token
     */
    Result<String> login(HttpServletRequest request, LoginFrom loginFrom);

    /**
     * 退出登录
     * @param request 请求对象
     * @return 响应
     */
    Result<String> logout(HttpServletRequest request);

    /**
     * 注册用户
     * @param userFrom 入参
     * @return 响应
     */
    Result<String> register(UserFrom userFrom);
}
