package com.weijin.recruitment.model.from.user;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/9/10 21:26
 */
@Data
public class UserFrom {
    @NotNull(message = "用户id不能为空")
    private Integer id;
    private String username;
    private String avatar;
}
