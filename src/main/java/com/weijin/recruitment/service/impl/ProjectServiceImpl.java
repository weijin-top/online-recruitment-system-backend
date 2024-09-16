package com.weijin.recruitment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.weijin.recruitment.converter.ProjectConverter;
import com.weijin.recruitment.model.entity.Project;
import com.weijin.recruitment.mapper.ProjectMapper;
import com.weijin.recruitment.model.from.project.ProjectFrom;
import com.weijin.recruitment.common.Result;
import com.weijin.recruitment.model.vo.project.ProjectVO;
import com.weijin.recruitment.service.IProjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.weijin.recruitment.util.SecurityUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author WeiJin
 * @since 2024-06-30
 */
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements IProjectService {

    @Resource
    private ProjectConverter projectConverter;

    @Override
    public Result<String> saveProject(ProjectFrom projectFrom) {
        Project project = projectConverter.fromToEntity(projectFrom);
        int inserted = baseMapper.insert(project);
        return inserted > 0 ? Result.success("项目经历添加成功") : Result.failed("项目经历添加失败");
    }

    @Override
    public Result<String> modifyProject(ProjectFrom projectFrom) {
        Project project = projectConverter.fromToEntity(projectFrom);
        int updated = baseMapper.updateById(project);
        return updated > 0 ? Result.success("项目经历修改成功") : Result.failed("项目经历修改失败");
    }

    @Override
    public Result<String> removeProject(Integer id) {
        int deleted = baseMapper.deleteById(id);
        return deleted > 0 ? Result.success("项目经历删除成功") : Result.failed("项目经历删除失败");
    }

    @Override
    public Result<List<ProjectVO>> queryProject() {
        LambdaQueryWrapper<Project> wrapper = new LambdaQueryWrapper<Project>()
                .eq(Project::getUserId, SecurityUtil.getUserId());
        List<Project> projects = baseMapper.selectList(wrapper);
        List<ProjectVO> projectVOS = projectConverter.listEntityToListVO(projects);
        return !projectVOS.isEmpty() ? Result.success("项目经历获取成功", projectVOS) : Result.failed("你暂时还没有项目经历");
    }
}
