package com.weijin.recruitment.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
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
public class ResumeDelivery implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer userId;

    private Integer postionId;

    /**
     * 投递状态 0未查看1感兴趣2已拒绝3邀面试
     */
    private Integer status;

    /**
     * 投递反馈
     */
    private String remark;

    /**
     * 投递日期
     */
    private LocalDateTime createTime;

    @TableLogic(value = "0", delval = "1")
    private Integer isDeleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPostionId() {
        return postionId;
    }

    public void setPostionId(Integer postionId) {
        this.postionId = postionId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "ResumeDelivery{" +
            "id = " + id +
            ", userId = " + userId +
            ", postionId = " + postionId +
            ", status = " + status +
            ", remark = " + remark +
            ", createTime = " + createTime +
            ", isDeleted = " + isDeleted +
        "}";
    }
}
