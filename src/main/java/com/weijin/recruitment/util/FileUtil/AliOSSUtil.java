package com.weijin.recruitment.util.FileUtil;

import cn.hutool.core.date.DateUtil;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.weijin.recruitment.exception.AppException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;

/**
 * @author WeiJin
 * @version 1.0
 */
@Component
@ConditionalOnProperty(name = "recruitment.storage.type", havingValue = "aliyun")
public class AliOSSUtil implements IFileUtil {

    @Value("${oss.endpoint}")
    private String endpoint;
    @Value("${oss.access-key-id}")
    private String accessKeyId;
    @Value("${oss.access-key-secret}")
    private String accessKeySecret;
    @Value("${oss.bucket-name}")
    private String bucketName;

    /**
     * 实现上传图片到OSS
     */
    @Override
    public String upload(MultipartFile file) {
        // 获取上传的文件的输入流
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            throw new AppException("获取文件输入流失败");
        }

        // 避免文件覆盖
        String originalFilename = file.getOriginalFilename();
        assert originalFilename != null : "上传文件时获取文件名失败，为null";
        String fileName = DateUtil.format(LocalDateTime.now(), "yyyyMMdd") + "/" + UUID.randomUUID() +
                originalFilename.substring(originalFilename.lastIndexOf("."));

        // 上传文件到 OSS
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        ossClient.putObject(bucketName, "recruitment/" + fileName, inputStream);

        // 文件访问路径
        String url = "recruitment/" + fileName;
        // 关闭ossClient
        ossClient.shutdown();
        // 把上传到oss的路径返回
        return url;
    }


    /**
     * 判断是否为常见图片格式
     *
     * @param filename 文件名
     * @return 结果
     */
    @Override
    public boolean isImage(String filename) {
        String lastName = filename.substring(filename.lastIndexOf(".") + 1);
        String[] lastnames = {"png", "jpg", "jpeg", "bmp", "webp", "svg"};
        return Arrays.asList(lastnames).contains(lastName);
    }

    /**
     * 判断文件是否大于2MB
     *
     * @param file 文件
     * @return 结果
     */
    @Override
    public boolean isOverSize(MultipartFile file) {
        return file.getSize() > 2 * 1024 * 1024;
    }
}
