package com.weijin.recruitment.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *      学历实体
 * </p>
 *
 * @author WeiJin
 * @since 2024-06-30
 */
@TableName("t_education")
public class Education implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer userId;

    private String schoolName;

    /**
     * 专业
     */
    private String major;

    /**
     * 学历,1小学2初中3中专4高中5大专6本科7研究生
     */
    private Integer education;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    /**
     * 描述
     */
    private String description;

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

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Integer getEducation() {
        return education;
    }

    public void setEducation(Integer education) {
        this.education = education;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "Education{" +
            "id = " + id +
            ", userId = " + userId +
            ", schoolName = " + schoolName +
            ", major = " + major +
            ", education = " + education +
            ", startTime = " + startTime +
            ", endTime = " + endTime +
            ", description = " + description +
            ", isDeleted = " + isDeleted +
        "}";
    }
}
