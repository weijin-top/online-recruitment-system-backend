package com.weijin.recruitment.model.from.position;

import com.weijin.recruitment.group.EducationGroup;
import com.weijin.recruitment.group.PositionGroup;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/7/8 19:40
 */
@Data
public class PositionFrom {

    @NotNull(message = "岗位id不能为空", groups = PositionGroup.ModifyPositionGroup.class)
    private Integer id;

    @NotBlank(message = "职位名称不能为空",groups = PositionGroup.SavePositionGroup.class)
    private String name;

    /**
     * 职位类型
     */
    @NotNull(message = "职位类型不能为空",groups = PositionGroup.SavePositionGroup.class)
    private Integer type;

    /**
     * 招聘人数
     */
    @NotNull(message = "招聘人数不能为空",groups = PositionGroup.SavePositionGroup.class)
    private Integer number;

//    @NotBlank(message = "最低新增不能为空",groups = PositionGroup.SavePositionGroup.class)
    @Min(value = 1,message = "最低薪资不能低于1元",groups = PositionGroup.SavePositionGroup.class)
    private Integer miniSalary;

    @NotNull(message = "最高薪资不能为空",groups = PositionGroup.SavePositionGroup.class)
    private Integer maxSalary;

    /**
     * 工作地点
     */
    @NotBlank(message = "工作地点不能为空",groups = PositionGroup.SavePositionGroup.class)
    private String jobPlace;

    /**
     * 学历要求
     */
    @Min(value = 0, message = "学历要求最低为0", groups =PositionGroup.SavePositionGroup.class)
    @Max(value = 7, message = "学历要求最高为7", groups = PositionGroup.SavePositionGroup.class)
    private Integer education;

    /**
     * 任职要求
     */
    @NotBlank(message = "任职要求不能为空",groups = PositionGroup.SavePositionGroup.class)
    private String jobRequire;

}
