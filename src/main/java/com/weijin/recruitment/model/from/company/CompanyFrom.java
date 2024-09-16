package com.weijin.recruitment.model.from.company;

import com.weijin.recruitment.group.companyGroup;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/7/3 15:04
 */
@Data
public class CompanyFrom {
    @NotNull(message = "公司id不能为空", groups = companyGroup.ModifyCompanyGroup.class)
    private Integer id;

    @NotBlank(message = "公司名称不能为空", groups = companyGroup.SaveCompanyGroup.class)
    private String name;
    @NotBlank(message = "公司别名不能为空", groups = companyGroup.SaveCompanyGroup.class)
    private String nickname;
    @NotBlank(message = "公司地址不能为空", groups = companyGroup.SaveCompanyGroup.class)
    private String address;
    @NotBlank(message = "公司logo不能为空", groups = companyGroup.SaveCompanyGroup.class)
    private String logo;
    @NotBlank(message = "公司简介不能为空", groups = companyGroup.SaveCompanyGroup.class)
    private String intro;
}
