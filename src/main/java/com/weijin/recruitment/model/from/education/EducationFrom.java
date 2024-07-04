package com.weijin.recruitment.model.from.education;


import com.weijin.recruitment.group.EducationGroup;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.YearMonth;


/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/7/4 18:16
 */
@Data
public class EducationFrom {

    @NotNull(message = "教育经历id不能为空", groups = EducationGroup.ModifyEducationGroup.class)
    private Integer id;

    @NotBlank(message = "学校名称不能为空", groups = EducationGroup.SaveEducationGroup.class)
    private String schoolName;

    @NotBlank(message = "所学专业不能为空", groups = EducationGroup.SaveEducationGroup.class)
    private String major;

    /**
     * 学历,1小学2初中3中专4高中5大专6本科7研究生
     */
    @Min(value = 1, message = "学历层次最低为1", groups = EducationGroup.SaveEducationGroup.class)
    @Max(value = 7, message = "学历层次最高为7", groups = EducationGroup.SaveEducationGroup.class)
    private Integer level;
    @NotNull(message = "开始时间不能为空", groups = EducationGroup.SaveEducationGroup.class)
    @DateTimeFormat(pattern = "yyyy-MM")
    private YearMonth startTime;
    @NotNull(message = "结束时间不能为空", groups = EducationGroup.SaveEducationGroup.class)
    @DateTimeFormat(pattern = "yyyy-MM")
    private YearMonth endTime;

    /**
     * 描述
     */
    @NotBlank(message = "校园经历不能为空", groups = EducationGroup.SaveEducationGroup.class)
    private String description;
}
