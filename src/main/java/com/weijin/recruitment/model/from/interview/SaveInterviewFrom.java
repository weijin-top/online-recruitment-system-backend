package com.weijin.recruitment.model.from.interview;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.weijin.recruitment.group.InterviewGroup;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/8/16 21:26
 */
@Data
public class SaveInterviewFrom {
    @NotNull(message = "简历投递id不能为空", groups = InterviewGroup.SaveInterviewGroup.class)
    private Integer rdId;
    @NotNull(message = "被邀请人id不能为空", groups = InterviewGroup.SaveInterviewGroup.class)
    private Integer userId;
    @FutureOrPresent(message = "面试时间只能在当前时间之后", groups = InterviewGroup.SaveInterviewGroup.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private LocalDateTime time;
    @NotBlank(message = "面试地点不能为空", groups = InterviewGroup.SaveInterviewGroup.class)
    private String address;
    @NotBlank(message = "面试备注不能为空", groups = InterviewGroup.SaveInterviewGroup.class)
    private String interviewRemark;
}
