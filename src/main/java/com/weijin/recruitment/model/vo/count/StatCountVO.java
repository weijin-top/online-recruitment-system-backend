package com.weijin.recruitment.model.vo.count;

import lombok.Data;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/9/16 14:39
 */
@Data
public class StatCountVO {
    /**
     * 求职人数
     */
    private Integer seekerCount;
    /**
     * 招聘者人数
     */
    private Integer recruiterCount;
    /**
     * 公司数量
     */
    private Integer companyCount;
    /**
     * 职位数量
     */
    private Integer positionCount;
}
