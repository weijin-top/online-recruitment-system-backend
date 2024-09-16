package com.weijin.recruitment.model.vo.interview;

import lombok.Data;


/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/9/10 14:58
 */
@Data
public class InterviewResultVO {
    private Integer id;
    private Integer userId;
    private String name;
    private String positionName;
    private String phone;
    private Integer status;
    private String email;
}
