package com.weijin.recruitment.controller;

import com.weijin.recruitment.group.EducationGroup;
import com.weijin.recruitment.model.from.education.EducationFrom;
import com.weijin.recruitment.model.result.Result;
import com.weijin.recruitment.model.vo.education.EducationVO;
import com.weijin.recruitment.service.IEducationService;
import jakarta.annotation.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 教育经历管理
 *
 * @author WeiJin
 * @since 2024-06-30
 */
@RestController
@RequestMapping("/api/education")
public class EducationController {

    @Resource
    private IEducationService iEducationService;

    /**
     * 添加教育经历
     *
     * @param educationFrom 入参
     * @return 响应
     */
    @PostMapping
    @PreAuthorize("hasAnyRole('seeker')")
    public Result<String> saveEducation(@Validated(EducationGroup.SaveEducationGroup.class)
                                        @RequestBody EducationFrom educationFrom) {
        return iEducationService.saveEducation(educationFrom);
    }

    /**
     * 修改教育经历
     *
     * @param educationFrom 入参
     * @return 响应
     */
    @PutMapping
    @PreAuthorize("hasAnyRole('seeker')")
    public Result<String> modifyEducation(@Validated(EducationGroup.ModifyEducationGroup.class)
                                          @RequestBody EducationFrom educationFrom) {
        return iEducationService.modifyEducation(educationFrom);
    }

    /**
     * 删除教育经历信息
     *
     * @param id 教育经历id
     * @return 响应
     */
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('seeker')")
    public Result<String> removeEducation(@PathVariable("id") Integer id) {
        return iEducationService.removeEducation(id);
    }

    /**
     * 获取本人教育经历
     *
     * @return 响应
     */
    @GetMapping
    @PreAuthorize("hasAnyRole('seeker')")
    public Result<List<EducationVO>> queryEducation() {
        return iEducationService.queryEducation();
    }
}
