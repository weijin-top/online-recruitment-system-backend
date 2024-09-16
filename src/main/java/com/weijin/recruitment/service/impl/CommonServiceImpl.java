package com.weijin.recruitment.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.weijin.recruitment.common.Result;
import com.weijin.recruitment.service.ICommonService;
import com.weijin.recruitment.util.AliOSSUtil;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/8/18 17:06
 */
@Service
public class CommonServiceImpl implements ICommonService {

    @Resource
    private AliOSSUtil aliOSSUtil;

    @SneakyThrows(IOException.class)
    @Override
    public Result<String> uploadImage(MultipartFile file) {
        if (!aliOSSUtil.isImage(Objects.requireNonNull(file.getOriginalFilename()))) {
            return Result.failed("该文件不是常用图片格式(png、jpg、jpeg、bmp)");
        }
        if (aliOSSUtil.isOverSize(file)) {
            return Result.failed("图片大小不能超过50KB");
        }
        String url = aliOSSUtil.upload(file);
        if (StringUtils.isBlank(url)) {
            return Result.failed("图片上传失败");
        }
        return Result.success("图片上传成功", url);
    }
}
