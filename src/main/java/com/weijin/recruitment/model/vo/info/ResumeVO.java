package com.weijin.recruitment.model.vo.info;

import com.weijin.recruitment.model.vo.education.EducationVO;
import com.weijin.recruitment.model.vo.job.JobVO;
import com.weijin.recruitment.model.vo.project.ProjectVO;
import lombok.Data;

import java.util.List;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/7/9 21:50
 */
@Data
public class ResumeVO {
    private Integer userId;

    private String postName;

    private String city;

    private String name;

    private String address;

    private Integer age;

    private String phone;

    private String email;

    private Integer gender;

    private String skill;

    private String summary;

    private List<EducationVO> educationVOS;

    private List<JobVO> jobVOS;

    private List<ProjectVO> projectVOS;
}
