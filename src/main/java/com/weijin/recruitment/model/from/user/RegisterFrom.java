package com.weijin.recruitment.model.from.user;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/7/3 15:31
 */
@Data
public class RegisterFrom {
    @NotBlank(message = "用户名不能为空")
    private String username;
    @NotBlank(message = "密码不能为空")
    private String password;
    @Min(value = 1,message = "角色只能是1或2")
    @Max(value = 2,message = "角色只能是1或2")
    private Integer roleId;
    @NotBlank(message = "验证码不能为空")
    private String code;

}
