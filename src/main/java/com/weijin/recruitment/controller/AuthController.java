package com.weijin.recruitment.controller;

import com.weijin.recruitment.model.from.auth.LoginFrom;
import com.weijin.recruitment.model.from.user.UserFrom;
import com.weijin.recruitment.model.result.Result;
import com.weijin.recruitment.service.IAuthService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * 认证管理
 *
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/7/2 15:25
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Resource
    private IAuthService iAuthService;

    /**
     * 用户登录
     *
     * @param request   request对象，用户获取sessionId
     * @param loginFrom 用户登录信息
     * @return token
     */
    @PostMapping("/login")
    public Result<String> login(HttpServletRequest request,
                                @Validated @RequestBody LoginFrom loginFrom) {
        return iAuthService.login(request, loginFrom);
    }


    /**
     * 退出登录
     *
     * @param request 请求对象
     * @return 响应
     */
    @DeleteMapping("/logout")
    public Result<String> logout(HttpServletRequest request) {
        return iAuthService.logout(request);
    }


    /**
     * 注册用户
     * @param userFrom 入参
     * @return 响应
     */
    @PostMapping("/register")
    public Result<String> register(@Validated @RequestBody UserFrom userFrom){
       return iAuthService.register(userFrom);
    }
}
