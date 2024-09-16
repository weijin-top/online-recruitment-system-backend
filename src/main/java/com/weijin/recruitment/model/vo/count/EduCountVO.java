package com.weijin.recruitment.model.vo.count;

import lombok.Data;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/9/16 17:57
 */
@Data
public class EduCountVO {
    /**
     * 专科及以下数量
     */
    private Integer juniorCollegeAndBelowCount;
    /**
     * 本科数量
     */
    private Integer undergraduateCount;
    /**
     * 硕士数量
     */
    private Integer masterCount;
    /**
     * 博士数量
     */
    private Integer doctorCount;

}
