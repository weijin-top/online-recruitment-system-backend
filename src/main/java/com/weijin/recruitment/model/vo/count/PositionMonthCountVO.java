package com.weijin.recruitment.model.vo.count;

import lombok.Data;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/9/16 19:55
 */
@Data
public class PositionMonthCountVO {
    /**
     * 月份
     */
    private String month;
    /**
     * 数量
     */
    private Integer count;
}
