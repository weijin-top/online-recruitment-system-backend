package com.weijin.recruitment.controller;

import com.weijin.recruitment.common.Result;
import com.weijin.recruitment.service.ICommonService;
import jakarta.annotation.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 公共接口
 *
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/8/18 17:04
 */
@RestController
@RequestMapping("/api/common")
public class CommonController {

    @Resource
    private ICommonService iCommonService;

    /**
     * 上传图片
     *
     * @param file 文件
     * @return 返回上传后的地址
     */
    @PostMapping("/uploadImage")
    @PreAuthorize("hasAnyRole('seeker','recruiter','admin')")
    public Result<String> uploadImage(@RequestPart("file") MultipartFile file) {
        return iCommonService.uploadImage(file);
    }
}
