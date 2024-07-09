package com.weijin.recruitment.controller;

import com.weijin.recruitment.group.InfoGroup;
import com.weijin.recruitment.model.from.info.InfoFrom;
import com.weijin.recruitment.model.vo.info.ResumeVO;
import com.weijin.recruitment.model.result.Result;
import com.weijin.recruitment.model.vo.info.InfoVO;
import com.weijin.recruitment.service.IInfoService;
import jakarta.annotation.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 个人信息管理
 *
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/7/3 22:55
 */
@RestController
@RequestMapping("/api/info")
public class InfoController {

    @Resource
    private IInfoService iInfoService;

    /**
     * 添加个人基本信息
     *
     * @param infoFrom 入参
     * @return 响应
     */
    @PostMapping
    @PreAuthorize("hasAnyRole('seeker')")
    public Result<String> saveInfo(@Validated(InfoGroup.SaveInfoGroup.class) @RequestBody InfoFrom infoFrom) {
        return iInfoService.saveInfo(infoFrom);
    }

    /**
     * 修改个人基本信息
     *
     * @param infoFrom 入参
     * @return 响应
     */
    @PutMapping
    @PreAuthorize("hasAnyRole('seeker')")
    public Result<String> modifyInfo(@Validated(InfoGroup.ModifyInfoGroup.class) @RequestBody InfoFrom infoFrom) {
        return iInfoService.modifyInfo(infoFrom);
    }

    /**
     * 获取个人基本信息
     *
     * @return 响应
     */
    @GetMapping
    @PreAuthorize("hasAnyRole('seeker')")
    public Result<InfoVO> queryInfo() {
        return iInfoService.queryInfo();
    }


    /**
     * 根据用户id获取简历
     *
     * @param userId 用户信息
     * @return 响应
     */
    @GetMapping("/resume/{userId}")
    @PreAuthorize("hasAnyRole('seeker','recruiter')")
    public Result<ResumeVO> queryResume(@PathVariable("userId") Integer userId) {
        return iInfoService.queryResume(userId);
    }
}
