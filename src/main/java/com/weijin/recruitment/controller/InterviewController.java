package com.weijin.recruitment.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.weijin.recruitment.group.InterviewGroup;
import com.weijin.recruitment.model.from.interview.ModifyInterviewFrom;
import com.weijin.recruitment.model.from.interview.SaveInterviewFrom;
import com.weijin.recruitment.common.Result;
import com.weijin.recruitment.model.vo.interview.InterviewInfoVO;
import com.weijin.recruitment.model.vo.interview.InterviewResultDetailVO;
import com.weijin.recruitment.model.vo.interview.InterviewResultVO;
import com.weijin.recruitment.model.vo.interview.InterviewVO;
import com.weijin.recruitment.service.IInterviewService;
import jakarta.annotation.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 分页获取我的面试
     *
     * @param pageNum  页码
     * @param pageSize 每页记录数
     * @return 响应
     */
    @GetMapping
    @PreAuthorize("hasAnyRole('seeker')")
    public Result<IPage<InterviewInfoVO>> queryInterviewInfo(@RequestParam(value = "pageNum", defaultValue = "1", required = false) Integer pageNum,
                                                             @RequestParam(value = "pageSize", defaultValue = "20", required = false) Integer pageSize) {
        return iInterviewService.queryInterviewInfo(pageNum, pageSize);
    }

    /**
     * 根据面试id获取面试进度
     *
     * @param id 面试id
     * @return 响应
     */
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('seeker')")
    public Result<InterviewVO> queryInterviewById(@PathVariable("id") Integer id) {
        return iInterviewService.queryInterviewById(id);
    }

    /**
     * 招聘者分页获取本公司面试信息
     *
     * @param pageNum      页码
     * @param pageSize     每页记录数
     * @param positionName 职位名称
     * @param status       状态
     * @return 响应
     */
    @GetMapping("/result")
    @PreAuthorize("hasAnyRole('recruiter')")
    public Result<IPage<InterviewResultVO>> queryInterviewResult(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                                                 @RequestParam(value = "pageSize", defaultValue = "20", required = false) Integer pageSize,
                                                                 @RequestParam(value = "positionName", required = false) String positionName,
                                                                 @RequestParam(value = "status", required = false) String status) {
        return iInterviewService.queryInterviewResult(pageNum, pageSize, positionName, status);
    }

    /**
     * 根据id获取面试结果
     *
     * @param id id
     * @return 响应
     */
    @GetMapping("/result/detail/{id}")
    @PreAuthorize("hasAnyRole('recruiter')")
    public Result<InterviewResultDetailVO> queryResultDetail(@PathVariable("id") Integer id) {
        return iInterviewService.queryResultDetail(id);
    }
}
