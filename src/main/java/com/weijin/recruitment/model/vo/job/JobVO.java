package com.weijin.recruitment.model.vo.job;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.weijin.recruitment.group.JobGroup;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.YearMonth;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/7/5 17:47
 */
@Data
public class JobVO {

    private Integer id;

    private String companyName;

    private String position;

    @JsonFormat(pattern = "yyyy-MM")
    private YearMonth startTime;

    @JsonFormat(pattern = "yyyy-MM")
    private YearMonth endTime;

    private String content;
}
