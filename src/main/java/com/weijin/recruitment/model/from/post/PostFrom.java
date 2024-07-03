package com.weijin.recruitment.model.from.post;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/7/2 17:46
 */
@Data
public class PostFrom {
    private Integer parentId;
    @NotBlank(message = "岗位名称不能为空")
    private String name;
}
