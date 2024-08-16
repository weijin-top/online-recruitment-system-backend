package com.weijin.recruitment.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *      简历投递实体
 * </p>
 *
 * @author WeiJin
 * @since 2024-06-30
 */
@TableName("t_resume_delivery")
@Data
public class ResumeDelivery implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(fill = FieldFill.INSERT)
    private Integer userId;

    private Integer positionId;

    /**
     * 投递状态 0未查看1已查看2感兴趣3已拒绝4邀面试
     */
    private Integer status;

    /**
     * 投递反馈
     */
    private String remark;

    /**
     * 投递日期
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableLogic(value = "0", delval = "1")
    private Integer isDeleted;


    @Override
    public String toString() {
        return "ResumeDelivery{" +
            "id = " + id +
            ", userId = " + userId +
            ", positionId = " + positionId +
            ", status = " + status +
            ", remark = " + remark +
            ", createTime = " + createTime +
            ", isDeleted = " + isDeleted +
        "}";
    }
}
