package com.weijin.recruitment.controller;

import com.weijin.recruitment.common.Result;
import com.weijin.recruitment.model.from.user.ModifyPasswordFrom;
import com.weijin.recruitment.model.from.user.UserFrom;
import com.weijin.recruitment.model.vo.user.UserVO;
import com.weijin.recruitment.service.IUserService;
import jakarta.annotation.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * 用户管理
 *
 * @author WeiJin
 * @since 2024-06-30
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Resource
    private IUserService iUserService;

    /**
     * 获取当前登录用户信息
     *
     * @return 响应
     */
    @GetMapping("/info")
    @PreAuthorize("hasAnyRole('seeker','recruiter','admin')")
    public Result<UserVO> getInfo() {
        return iUserService.getInfo();
    }

    /**
     * 修改用户信息
     *
     * @param userFrom 用户信息
     * @return 用户名
     */
    @PutMapping
    @PreAuthorize("hasAnyRole('seeker','recruiter','admin')")
    public Result<String> modifyUser(@RequestBody UserFrom userFrom) {
        return iUserService.modifyUser(userFrom);
    }

    /**
     * 修改密码
     *
     * @param modifyPasswordFrom 入参
     * @return 响应
     */
    @PutMapping("/password")
    @PreAuthorize("hasAnyRole('seeker','recruiter','admin')")
    public Result<String> modifyPassword(@RequestBody ModifyPasswordFrom modifyPasswordFrom) {
        return iUserService.modifyPassword(modifyPasswordFrom);
    }

}
