package com.weijin.recruitment.model.vo.resumedelivery;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/9/8 13:46
 */
@Data
public class DeliveryInfoVO {
    private Integer id;
    private String companyNickname;
    private String positionName;
    private String companyLogo;
    private String jobPlace;
    private Integer miniSalary;
    private Integer maxSalary;
    private Integer positionStatus;
    private Integer education;
    private Integer deliveryStatus;
    private Integer positionId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
}