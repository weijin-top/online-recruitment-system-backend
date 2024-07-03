package com.weijin.recruitment.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
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
@Data
public class Position implements Serializable {

    @Serial
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
