package com.weijin.recruitment.model.from.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/9/10 22:10
 */
@Data
public class ModifyPasswordFrom {
    @NotNull(message = "用户id不能为空")
    private Integer id;
    @NotBlank(message = "旧密码不能为空")
    private String oldPassword;
    @NotBlank(message = "新密码不能为空")
    private String newPassword;
    @NotBlank(message = "确认密码不能为空")
    private String confirmPassword;
}
