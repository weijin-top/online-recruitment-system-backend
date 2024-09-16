package com.weijin.recruitment.model.vo.resumedelivery;

import lombok.Data;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/9/9 17:10
 */
@Data
public class ResumeDeliveryInfoVO {
    private Integer id;
    private Integer userId;
    private String name;
    private String phone;
    private String email;
    private String positionName;
    private Integer education;
    private String address;
    private Integer status;

}
