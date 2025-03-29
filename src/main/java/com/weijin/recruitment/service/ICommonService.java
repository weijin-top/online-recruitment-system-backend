package com.weijin.recruitment.service;

import com.weijin.recruitment.common.Result;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/8/18 17:05
 */

public interface ICommonService {

    /**
     * 上传图片
     *
     * @param file 文件
     * @return 返回上传后的地址
     */
    Result<String> uploadImage(MultipartFile file);
}
