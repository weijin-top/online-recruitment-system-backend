package com.weijin.recruitment.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.YearMonth;

/**
 * <p>
 * 项目经历实体
 * </p>
 *
 * @author WeiJin
 * @since 2024-06-30
 */
@TableName("t_project")
@Data
public class Project implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(fill = FieldFill.INSERT)
    private Integer userId;

    private String projectName;

    private YearMonth startTime;

    private YearMonth endTime;

    /**
     * 项目内容
     */
    private String content;
    @TableLogic(value = "0", delval = "1")
    private Integer isDeleted;


    @Override
    public String toString() {
        return "Project{" +
                "id = " + id +
                ", userId = " + userId +
                ", projectName = " + projectName +
                ", startTime = " + startTime +
                ", endTime = " + endTime +
                ", content = " + content +
                ", isDeleted = " + isDeleted +
                "}";
    }
}
