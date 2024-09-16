package com.weijin.recruitment.model.vo.position;

import lombok.Data;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/7/9 17:40
 */
@Data
public class PositionSimpleVO {
    private Integer id;

    private String name;

    private Integer miniSalary;

    private Integer maxSalary;

    private Integer education;

    private String companyName;

    private String companyNickname;

    private String postName;

    private String logo;

    private String jobPlace;
    private Integer status;
}
