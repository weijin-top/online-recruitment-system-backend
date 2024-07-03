package com.weijin.recruitment.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/7/3 22:41
 */
@Data
@TableName("t_info")
public class Info implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(fill = FieldFill.INSERT)
    private Integer userId;

    private Integer postId;

    private String name;

    private String city;

    private String address;

    private Integer age;

    private String phone;

    private String email;

    private Integer gender;

    private String skill;

    private String summary;

    @TableLogic(value = "0", delval = "1")
    private Integer isDeleted;

    @Override
    public String toString() {
        return "Info{" +
                "id=" + id +
                ", userId=" + userId +
                ", postId=" + postId +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", skill='" + skill + '\'' +
                ", summary='" + summary + '\'' +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
