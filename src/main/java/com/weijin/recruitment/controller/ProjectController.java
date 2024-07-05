package com.weijin.recruitment.controller;

import com.weijin.recruitment.group.ProjectGroup;
import com.weijin.recruitment.model.from.project.ProjectFrom;
import com.weijin.recruitment.model.result.Result;
import com.weijin.recruitment.model.vo.project.ProjectVO;
import com.weijin.recruitment.service.IProjectService;
import jakarta.annotation.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 项目经历管理
 *
 * @author WeiJin
 * @since 2024-06-30
 */
@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Resource
    private IProjectService iProjectService;

    /**
     * 添加项目经历
     *
     * @param projectFrom 入参
     * @return 响应
     */
    @PostMapping
    @PreAuthorize("hasAnyRole('seeker')")
    public Result<String> saveProject(@Validated(ProjectGroup.SaveProjectGroup.class) @RequestBody ProjectFrom projectFrom) {
        return iProjectService.saveProject(projectFrom);
    }

    /**
     * 修改项目经历
     *
     * @param projectFrom 入参
     * @return 响应
     */
    @PutMapping
    @PreAuthorize("hasAnyRole('seeker')")
    public Result<String> modifyProject(@Validated(ProjectGroup.ModifyProjectGroup.class) @RequestBody ProjectFrom projectFrom) {
        return iProjectService.modifyProject(projectFrom);
    }

    /**
     * 删除项目经历
     *
     * @param id 项目经历id
     * @return 响应
     */
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('seeker')")
    public Result<String> removeProject(@PathVariable("id") Integer id) {
        return iProjectService.removeProject(id);
    }

    /**
     * 获取本人项目经历
     *
     * @return 响应
     */
    @GetMapping
    @PreAuthorize("hasAnyRole('seeker')")
    public Result<List<ProjectVO>> queryProject() {
        return iProjectService.queryProject();
    }
}
