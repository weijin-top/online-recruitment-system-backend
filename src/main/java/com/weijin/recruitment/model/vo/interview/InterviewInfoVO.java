package com.weijin.recruitment.model.vo.interview;

import lombok.Data;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/9/8 20:12
 */
@Data
public class InterviewInfoVO {
    private Integer id;
    private String positionName;
    private String companyNickname;
    private String jobPlace;
    private Integer status;
}
