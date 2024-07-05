package com.weijin.recruitment.model.vo.project;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.weijin.recruitment.group.ProjectGroup;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.YearMonth;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/7/5 20:36
 */
@Data
public class ProjectVO {
    private Integer id;
    private String projectName;
    @JsonFormat(pattern = "yyyy-MM")
    private YearMonth startTime;
    @JsonFormat(pattern = "yyyy-MM")
    private YearMonth endTime;
    private String content;
}
