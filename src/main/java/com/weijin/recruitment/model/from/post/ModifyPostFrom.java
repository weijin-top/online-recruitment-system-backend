package com.weijin.recruitment.model.from.post;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.security.Principal;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/9/14 19:32
 */
@Data
public class ModifyPostFrom {
    @NotNull(message = "职位类型id不能为空")
    private Integer id;
    @NotBlank(message = "职位类型名称不能为空")
    private String name;
}
