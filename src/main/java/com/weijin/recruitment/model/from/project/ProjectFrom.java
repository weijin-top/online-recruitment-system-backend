package com.weijin.recruitment.model.from.project;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.weijin.recruitment.group.ProjectGroup;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.YearMonth;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/7/5 20:21
 */
@Data
public class ProjectFrom {
    @NotNull(message = "项目经历id不能为空", groups = ProjectGroup.ModifyProjectGroup.class)
    private Integer id;
    @NotBlank(message = "项目名称不能为空", groups = ProjectGroup.SaveProjectGroup.class)
    private String projectName;
    @NotNull(message = "开始时间不能为空", groups = ProjectGroup.SaveProjectGroup.class)
    private YearMonth startTime;
    @NotNull(message = "结束时间不能为空", groups = ProjectGroup.SaveProjectGroup.class)
    private YearMonth endTime;
    @NotBlank(message = "项目内容不能为空", groups = ProjectGroup.SaveProjectGroup.class)
    private String content;
}
