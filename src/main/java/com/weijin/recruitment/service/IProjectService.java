package com.weijin.recruitment.service;

import com.weijin.recruitment.model.entity.Project;
import com.baomidou.mybatisplus.extension.service.IService;
import com.weijin.recruitment.model.from.project.ProjectFrom;
import com.weijin.recruitment.model.result.Result;
import com.weijin.recruitment.model.vo.project.ProjectVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author WeiJin
 * @since 2024-06-30
 */
public interface IProjectService extends IService<Project> {

    /**
     * 添加项目经历
     *
     * @param projectFrom 入参
     * @return 响应
     */
    Result<String> saveProject(ProjectFrom projectFrom);

    /**
     * 修改项目经历
     *
     * @param projectFrom 入参
     * @return 响应
     */
    Result<String> modifyProject(ProjectFrom projectFrom);

    /**
     * 删除项目经历
     *
     * @param id 项目经历id
     * @return 响应
     */
    Result<String> removeProject(Integer id);

    /**
     * 获取本人项目经历
     *
     * @return 响应
     */
    Result<List<ProjectVO>> queryProject();

}
