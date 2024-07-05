package com.weijin.recruitment.model.from.job;

import com.weijin.recruitment.group.JobGroup;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.YearMonth;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/7/5 17:31
 */
@Data
public class JobFrom {

    @NotNull(message = "工作/实现经历不能为空", groups = JobGroup.ModifyJobGroup.class)
    private Integer id;

    @NotBlank(message = "公司名称不能为空", groups = JobGroup.SaveJobGroup.class)
    private String companyName;

    @NotBlank(message = "职位不能为空", groups = JobGroup.SaveJobGroup.class)
    private String position;

    @NotNull(message = "开始时间不能为空", groups = JobGroup.SaveJobGroup.class)
    @DateTimeFormat(pattern = "yyyy-MM")
    private YearMonth startTime;

    @NotNull(message = "结束时间不能为空", groups = JobGroup.SaveJobGroup.class)
    @DateTimeFormat(pattern = "yyyy-MM")
    private YearMonth endTime;

    @NotBlank(message = "工作内容不能为空", groups = JobGroup.SaveJobGroup.class)
    private String content;
}
