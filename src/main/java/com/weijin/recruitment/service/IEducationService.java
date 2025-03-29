package com.weijin.recruitment.service;

import com.weijin.recruitment.model.entity.Education;
import com.baomidou.mybatisplus.extension.service.IService;
import com.weijin.recruitment.model.from.education.EducationFrom;
import com.weijin.recruitment.common.Result;
import com.weijin.recruitment.model.vo.education.EducationVO;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author WeiJin
 * @since 2024-06-30
 */
public interface IEducationService extends IService<Education> {

    /**
     * 添加教育经历
     *
     * @param educationFrom 入参
     * @return 响应
     */
    Result<String> saveEducation(EducationFrom educationFrom);

    /**
     * 修改教育经历
     *
     * @param educationFrom 入参
     * @return 响应
     */
    Result<String> modifyEducation(EducationFrom educationFrom);

    /**
     * 删除教育经历信息
     *
     * @param id 教育经历id
     * @return 响应
     */
    Result<String> removeEducation(Integer id);

    /**
     * 获取本人教育经历
     *
     * @return 响应
     */
    Result<List<EducationVO>> queryEducation();

}
