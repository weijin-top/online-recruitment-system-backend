package com.weijin.recruitment.model.from.interview;

import com.weijin.recruitment.group.InterviewGroup;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/8/16 21:56
 */
@Data
public class ModifyInterviewFrom {

    @NotNull(message = "简历投递id不能为空",groups = InterviewGroup.ModifyInterviewGroup.class)
    private Integer id;
    @Min(value = 1,message = "面试结果只能是1或2",groups = InterviewGroup.ModifyInterviewGroup.class)
    @Max(value = 2,message = "面试结果只能是1或2",groups = InterviewGroup.ModifyInterviewGroup.class)
    private Integer status;
    @NotBlank(message = "面试结果备注不能为空",groups = InterviewGroup.ModifyInterviewGroup.class)
    private String resultRemark;
}
