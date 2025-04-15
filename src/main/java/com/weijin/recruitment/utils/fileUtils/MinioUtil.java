package com.weijin.recruitment.utils.fileUtils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.http.Method;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2025/3/20 10:56
 */
@Component
@ConditionalOnProperty(name = "recruitment.storage.type", havingValue = "minio")
public class MinioUtil implements IFileUtil {
    @Value("${minio.bucket-name}")
    private String bucketName;

    @Resource
    private MinioClient minioClient;

    /**
     * 文件上传
     *
     * @param file 文件
     * @return 上传后的路径
     */
    public String upload(@RequestParam("file") MultipartFile file) {

        // 生成文件名(日期文件夹)
        String suffix = FileUtil.getSuffix(file.getOriginalFilename());
        String uuid = IdUtil.simpleUUID();
        String fileName = "recruitment/" + DateUtil.format(LocalDateTime.now(), "yyyyMMdd") + "/" + uuid + "." + suffix;
        //  try-with-resource 语法糖自动释放流
        try (InputStream inputStream = file.getInputStream()) {
            // 文件上传
            PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                    .bucket(bucketName)
                    .object(fileName)
                    .contentType(file.getContentType())
                    .stream(inputStream, inputStream.available(), -1)
                    .build();
            minioClient.putObject(putObjectArgs);

            // 返回文件路径
            String fileUrl;
            GetPresignedObjectUrlArgs getPresignedObjectUrlArgs = GetPresignedObjectUrlArgs.builder()
                    .bucket(bucketName).object(fileName)
                    .method(Method.GET)
                    .build();

            fileUrl = minioClient.getPresignedObjectUrl(getPresignedObjectUrlArgs);
            fileUrl = fileUrl.substring(0, fileUrl.indexOf("?"));
            fileUrl = fileUrl.substring(fileUrl.lastIndexOf("recruitment"));
            return fileUrl;
        } catch (Exception e) {
            e.printStackTrace();
            // 出现异常返回null
            return null;
        }
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
