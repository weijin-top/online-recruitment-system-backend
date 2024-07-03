package com.weijin.recruitment.controller;

import com.weijin.recruitment.model.from.info.InfoFrom;
import com.weijin.recruitment.model.result.Result;
import com.weijin.recruitment.service.IInfoService;
import jakarta.annotation.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Result<String> saveInfo(@Validated @RequestBody InfoFrom infoFrom) {
        return iInfoService.saveInfo(infoFrom);
    }


}
