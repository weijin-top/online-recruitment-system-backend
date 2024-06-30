package com.weijin.recruitment.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *      面试邀约实体
 * </p>
 *
 * @author WeiJin
 * @since 2024-06-30
 */
@TableName("t_interview")
public class Interview implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

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

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInterviewRemark() {
        return interviewRemark;
    }

    public void setInterviewRemark(String interviewRemark) {
        this.interviewRemark = interviewRemark;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getResultRemark() {
        return resultRemark;
    }

    public void setResultRemark(String resultRemark) {
        this.resultRemark = resultRemark;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

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
