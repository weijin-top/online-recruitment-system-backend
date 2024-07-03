package com.weijin.recruitment.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * <p>
 *      公司实体
 * </p>
 *
 * @author WeiJin
 * @since 2024-06-30
 */
@TableName("t_company")
@Data
public class Company implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(fill = FieldFill.INSERT)
    private Integer userId;

    private String name;

    private String address;

    private String logo;

    /**
     * 公司简介
     */
    private String intro;

    /**
     * 状态 0未审核 1通过 2未通过
     */
    private Integer status;

    @TableLogic(value = "0", delval = "1")
    private Integer isDeleted;


    @Override
    public String toString() {
        return "Company{" +
            "id = " + id +
            ", userId = " + userId +
            ", name = " + name +
            ", address = " + address +
            ", logo = " + logo +
            ", intro = " + intro +
            ", status = " + status +
            ", isDeleted = " + isDeleted +
        "}";
    }
}
