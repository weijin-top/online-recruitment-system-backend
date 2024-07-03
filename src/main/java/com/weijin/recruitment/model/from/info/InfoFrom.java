package com.weijin.recruitment.model.from.info;

import jakarta.validation.constraints.*;
import lombok.Data;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/7/3 22:58
 */
@Data
public class InfoFrom {
    @NotNull(message = "意向岗位不能为空")
    private Integer postId;
    @NotBlank(message = "意向城市不能为空")
    private String city;
    @NotBlank(message = "真实姓名不能为空")
    private String name;
    @NotBlank(message = "现居住地址不能为空")
    private String address;
    @Min(value = 18, message = "年龄至少18岁")
    @Max(value = 65, message = "年龄最大65岁")
    private Integer age;
    @Pattern(regexp = "^1[3-9]\\d{9}$", message = "手机号格式不正确")
    private String phone;
    @Email(message = "邮箱格式不正确")
    private String email;
    @Min(value = 0, message = "性别只能是0或1")
    @Max(value = 1, message = "性别只能是0或1")
    private Integer gender;
    @NotBlank(message = "技能不能为空")
    private String skill;
    @NotBlank(message = "个人总结不能为空")
    private String summary;
}
