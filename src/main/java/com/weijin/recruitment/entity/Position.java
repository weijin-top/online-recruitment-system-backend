package com.weijin.recruitment.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *      职位实体
 * </p>
 *
 * @author WeiJin
 * @since 2024-06-30
 */
@TableName("t_position")
public class Position implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer companyId;

    /**
     * 职位名称
     */
    private String name;

    /**
     * 职位类型
     */
    private String type;

    /**
     * 招聘人数
     */
    private Integer number;

    private Integer miniSalary;

    private Integer maxSalary;

    /**
     * 工作地点
     */
    private String jobPlace;

    /**
     * 学历要求
     */
    private Integer education;

    /**
     * 任职要求
     */
    private String jobRequire;

    /**
     * 0未审核1通过2未通过3已下架
     */
    private Integer status;

    /**
     * 创建时间
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

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getMiniSalary() {
        return miniSalary;
    }

    public void setMiniSalary(Integer miniSalary) {
        this.miniSalary = miniSalary;
    }

    public Integer getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(Integer maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getJobPlace() {
        return jobPlace;
    }

    public void setJobPlace(String jobPlace) {
        this.jobPlace = jobPlace;
    }

    public Integer getEducation() {
        return education;
    }

    public void setEducation(Integer education) {
        this.education = education;
    }

    public String getJobRequire() {
        return jobRequire;
    }

    public void setJobRequire(String jobRequire) {
        this.jobRequire = jobRequire;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        return "Position{" +
            "id = " + id +
            ", companyId = " + companyId +
            ", name = " + name +
            ", type = " + type +
            ", number = " + number +
            ", miniSalary = " + miniSalary +
            ", maxSalary = " + maxSalary +
            ", jobPlace = " + jobPlace +
            ", education = " + education +
            ", jobRequire = " + jobRequire +
            ", status = " + status +
            ", createTime = " + createTime +
            ", isDeleted = " + isDeleted +
        "}";
    }
}
