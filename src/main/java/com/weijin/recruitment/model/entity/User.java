package com.weijin.recruitment.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户实体
 * </p>
 *
 * @author WeiJin
 * @since 2024-06-30
 */
@TableName("t_user")
@Data
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String username;

    private String password;

    private String avatar;

    /**
     * 1求职者2招聘者3管理员
     */
    private Integer roleId;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 逻辑删除
     */
    @TableLogic(value = "0", delval = "1")
    private Integer isDeleted;


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", avatar='" + avatar + '\'' +
                ", roleId=" + roleId +
                ", createTime=" + createTime +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
