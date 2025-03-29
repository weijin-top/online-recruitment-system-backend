package com.weijin.recruitment.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.weijin.recruitment.common.Result;
import com.weijin.recruitment.service.ICommonService;
import com.weijin.recruitment.utils.fileUtils.IFileUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/8/18 17:06
 */
@Service
public class CommonServiceImpl implements ICommonService {

    @Resource
    private IFileUtil fileUtil;

    @Override
    public Result<String> uploadImage(MultipartFile file) {
        if (!fileUtil.isImage(Objects.requireNonNull(file.getOriginalFilename()))) {
            return Result.failed("该文件不是常用图片格式(png、jpg、jpeg、bmp、webp、svg)");
        }
        if (fileUtil.isOverSize(file)) {
            return Result.failed("图片大小不能超过2MB");
        }
        String url = fileUtil.upload(file);
        if (StringUtils.isBlank(url)) {
            return Result.failed("图片上传失败");
        }
        return Result.success("图片上传成功", url);
    }
}
