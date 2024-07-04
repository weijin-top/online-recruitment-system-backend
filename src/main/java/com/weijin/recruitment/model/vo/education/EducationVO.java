package com.weijin.recruitment.model.vo.education;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.YearMonth;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/7/4 19:15
 */
@Data
public class EducationVO {
    private Integer id;

    private String schoolName;

    private String major;

    private Integer level;

    @JsonFormat(pattern = "yyyy-MM")
    private YearMonth startTime;

    @JsonFormat(pattern = "yyyy-MM")
    private YearMonth endTime;

    private String description;
}
