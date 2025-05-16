package com.weijin.recruitment.model.vo.user;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/8/17 23:31
 */
@Data
public class UserVO {
    private Integer id;

    private String username;

    private String avatar;

    /**
     * 1求职者2招聘者3管理员
     */
    private Integer roleId;

    private String password;

    private LocalDateTime createTime;
}
