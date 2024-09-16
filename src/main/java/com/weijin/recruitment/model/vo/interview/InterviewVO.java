package com.weijin.recruitment.model.vo.interview;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/9/8 21:32
 */
@Data
public class InterviewVO {
    private Integer id;

    /**
     * 面试时间
     */
    private LocalDateTime time;

    /**
     * 面试地点
     */
    private String address;

    /**
     * 面试备注
     */
    private String interviewRemark;

    /**
     * 面试状态 0待面试1通过2未通过
     */
    private Integer status;

    /**
     * 面试结果备注
     */
    private String resultRemark;
}
