package com.weijin.recruitment.controller;

import com.weijin.recruitment.model.from.auth.LoginFrom;
import com.weijin.recruitment.model.from.user.RegisterFrom;
import com.weijin.recruitment.common.Result;
import com.weijin.recruitment.service.IAuthService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
     * @param request request对象，用户获取sessionId
     * @param registerFrom 入参
     * @return 响应
     */
    @PostMapping("/register")
    public Result<String> register(HttpServletRequest request,@Validated @RequestBody RegisterFrom registerFrom){
       return iAuthService.register(request,registerFrom);
    }

    /**
     * 获取图片验证码
     * @param request  request对象，获取sessionId
     * @param response response对象，响应图片
     */
    @GetMapping("/captcha")
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response) {
        iAuthService.getCaptcha(request, response);
    }
}
