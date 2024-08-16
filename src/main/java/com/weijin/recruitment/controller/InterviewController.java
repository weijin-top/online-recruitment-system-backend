package com.weijin.recruitment.controller;

import com.weijin.recruitment.group.InterviewGroup;
import com.weijin.recruitment.model.from.interview.ModifyInterviewFrom;
import com.weijin.recruitment.model.from.interview.SaveInterviewFrom;
import com.weijin.recruitment.model.result.Result;
import com.weijin.recruitment.service.IInterviewService;
import jakarta.annotation.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * 面试管理
 *
 * @author WeiJin
 * @since 2024-06-30
 */
@RestController
@RequestMapping("/api/interview")
public class InterviewController {

    @Resource
    private IInterviewService iInterviewService;


    /**
     * 邀约面试
     *
     * @param saveInterviewFrom 入参
     * @return 响应
     */
    @PostMapping
    @PreAuthorize("hasAnyRole('recruiter')")
    public Result<String> saveInterview(@RequestBody @Validated(InterviewGroup.SaveInterviewGroup.class)
                                        SaveInterviewFrom saveInterviewFrom) {
        return iInterviewService.saveInterview(saveInterviewFrom);
    }

    /**
     * 通知面试结果
     *
     * @param modifyInterviewFrom 入参
     * @return 响应
     */
    @PutMapping
    @PreAuthorize("hasAnyRole('recruiter')")
    public Result<String> modifyInterview(@RequestBody @Validated(InterviewGroup.ModifyInterviewGroup.class)
                                          ModifyInterviewFrom modifyInterviewFrom) {
        return iInterviewService.modifyInterview(modifyInterviewFrom);
    }

}
