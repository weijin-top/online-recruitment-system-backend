package com.weijin.recruitment.controller;

import com.weijin.recruitment.group.JobGroup;
import com.weijin.recruitment.model.from.job.JobFrom;
import com.weijin.recruitment.common.Result;
import com.weijin.recruitment.model.vo.job.JobVO;
import com.weijin.recruitment.service.IJobService;
import jakarta.annotation.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 工作经历管理
 *
 * @author WeiJin
 * @since 2024-06-30
 */
@RestController
@RequestMapping("/api/job")
public class JobController {

    @Resource
    private IJobService iJobService;

    /**
     * 添加工作/实习经历
     *
     * @param jobFrom 入参
     * @return 响应
     */
    @PostMapping
    @PreAuthorize("hasAnyRole('seeker')")
    public Result<String> saveJob(@Validated(JobGroup.SaveJobGroup.class) @RequestBody JobFrom jobFrom) {
        return iJobService.saveJob(jobFrom);
    }

    /**
     * 修改工作/实习经历
     *
     * @param jobFrom 入参
     * @return 响应
     */
    @PutMapping
    @PreAuthorize("hasAnyRole('seeker')")
    public Result<String> modifyJob(@Validated(JobGroup.ModifyJobGroup.class) @RequestBody JobFrom jobFrom) {
        return iJobService.modifyJob(jobFrom);
    }

    /**
     * 删除工作/实习经历
     *
     * @param id 工作/实现经历id
     * @return 响应
     */
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('seeker')")
    public Result<String> removeJob(@PathVariable("id") Integer id) {
        return iJobService.removeJob(id);
    }

    /**
     * 获取本人工作/实现经历
     *
     * @return 响应
     */
    @GetMapping
    @PreAuthorize("hasAnyRole('seeker')")
    public Result<List<JobVO>> queryJob() {
        return iJobService.queryJob();
    }
}
