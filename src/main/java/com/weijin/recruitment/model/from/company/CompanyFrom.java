package com.weijin.recruitment.model.from.company;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/7/3 15:04
 */
@Data
public class CompanyFrom {
    @NotBlank(message = "公司名称不能为空")
    private String name;
    @NotBlank(message = "公司地址不能为空")
    private String address;
    @NotBlank(message = "公司logo不能为空")
    private String logo;
    @NotBlank(message = "公司简介不能为空")
    private String intro;
}
