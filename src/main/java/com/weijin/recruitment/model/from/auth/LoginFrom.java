package com.weijin.recruitment.model.from.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/7/2 15:29
 */
@Data
public class LoginFrom {
    @NotBlank(message = "用户名不能为空")
    private String username;
    @NotBlank(message = "密码不能为空")
    private String password;
}
