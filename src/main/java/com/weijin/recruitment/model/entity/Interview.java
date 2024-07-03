package com.weijin.recruitment.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 面试邀约实体
 * </p>
 *
 * @author WeiJin
 * @since 2024-06-30
 */
@TableName("t_interview")
@Data
public class Interview implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(fill = FieldFill.INSERT)
    private Integer userId;

    private Integer positionId;

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
     * 面试状态 0未通过1通过
     */
    private Integer status;

    /**
     * 面试结果备注
     */
    private String resultRemark;

    @TableLogic(value = "0", delval = "1")
    private Integer isDeleted;


    @Override
    public String toString() {
        return "Interview{" +
                "id = " + id +
                ", userId = " + userId +
                ", positionId = " + positionId +
                ", time = " + time +
                ", address = " + address +
                ", interviewRemark = " + interviewRemark +
                ", status = " + status +
                ", resultRemark = " + resultRemark +
                ", isDeleted = " + isDeleted +
                "}";
    }
}
