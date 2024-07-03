package com.weijin.recruitment.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *      实习经历实体
 * </p>
 *
 * @author WeiJin
 * @since 2024-06-30
 */
@TableName("t_practice")
@Data
public class Practice implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(fill = FieldFill.INSERT)
    private Integer userId;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 职位
     */
    private String position;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    /**
     * 工作内容
     */
    private String content;
    @TableLogic(value = "0", delval = "1")
    private Integer isDeleted;


    @Override
    public String toString() {
        return "Practice{" +
            "id = " + id +
            ", userId = " + userId +
            ", companyName = " + companyName +
            ", position = " + position +
            ", startTime = " + startTime +
            ", endTime = " + endTime +
            ", content = " + content +
            ", isDeleted = " + isDeleted +
        "}";
    }
}
