package com.weijin.recruitment.utils.fileUtils;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2025/3/20 13:35
 */
public interface IFileUtil {
    /**
     * 文件上传
     *
     * @param file 文件
     * @return 返回文件路径
     */
    String upload(MultipartFile file);

    /**
     * 判断是否为常见图片格式
     *
     * @param filename 文件名
     * @return 结果
     */
    boolean isImage(String filename);

    /**
     * 判断文件是否大于2MB
     *
     * @param file 文件
     * @return 结果
     */
    boolean isOverSize(MultipartFile file);
}
