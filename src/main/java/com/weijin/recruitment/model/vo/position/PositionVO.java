package com.weijin.recruitment.model.vo.position;

import lombok.Data;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/8/23 18:23
 */
@Data
public class PositionVO {
    private Integer id;


    /**
     * 职位名称
     */
    private String name;

    /**
     * 职位类型
     */
    private Integer type;

    /**
     * 招聘人数
     */
    private Integer number;

    private Integer miniSalary;

    private Integer maxSalary;

    /**
     * 工作地点
     */
    private String jobPlace;

    /**
     * 学历要求
     */
    private Integer education;

    /**
     * 任职要求
     */
    private String jobRequire;

    /**
     * 0未审核1通过2未通过3已下架
     */
    private Integer status;


}
