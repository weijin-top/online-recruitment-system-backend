package com.weijin.recruitment.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.YearMonth;

/**
 * <p>
 * 学历实体
 * </p>
 *
 * @author WeiJin
 * @since 2024-06-30
 */
@TableName("t_education")
@Data
public class Education implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(fill = FieldFill.INSERT)
    private Integer userId;

    private String schoolName;

    /**
     * 专业
     */
    private String major;

    /**
     * 学历,1小学2初中3中专4高中5大专6本科7研究生
     */
    private Integer level;

    private YearMonth startTime;

    private YearMonth endTime;

    /**
     * 描述
     */
    private String description;

    @TableLogic(value = "0", delval = "1")
    private Integer isDeleted;


    @Override
    public String toString() {
        return "Education{" +
                "id = " + id +
                ", userId = " + userId +
                ", schoolName = " + schoolName +
                ", major = " + major +
                ", level = " + level +
                ", startTime = " + startTime +
                ", endTime = " + endTime +
                ", description = " + description +
                ", isDeleted = " + isDeleted +
                "}";
    }
}
