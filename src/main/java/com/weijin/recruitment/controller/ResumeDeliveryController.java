package com.weijin.recruitment.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.weijin.recruitment.model.result.Result;
import com.weijin.recruitment.model.vo.info.ResumeVO;
import com.weijin.recruitment.service.IInfoService;
import com.weijin.recruitment.service.IResumeDeliveryService;
import com.weijin.recruitment.util.SecurityUtil;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * 简历投递管理
 *
 * @author WeiJin
 * @since 2024-06-30
 */
@RestController
@RequestMapping("/api/resumeDelivery")
public class ResumeDeliveryController {

    @Resource
    private IInfoService iInfoService;
    @Resource
    private IResumeDeliveryService iResumeDeliveryService;


    /**
     * 投递简历
     *
     * @param positionId 职位id
     * @return 响应
     */
    @PostMapping("/{positionId}")
    @PreAuthorize("hasAnyRole('seeker')")
    public Result<String> saveResumeDelivery(@PathVariable("positionId") Integer positionId) {
        //未完善简历不能投递简历
        Result<ResumeVO> result = iInfoService.queryResume(SecurityUtil.getUserId());
        if (Objects.isNull(result.getData())) {
            return Result.failed("请先完成简历再尝试投递该职位");
        }
        if (StringUtils.isBlank(result.getData().getSkill())) {
            return Result.failed("请先填写个人信息再尝试投递该职位");
        }
        if (result.getData().getEducationVOS().isEmpty()) {
            return Result.failed("请先填写教育经历再尝试投递该职位");
        }
        if (result.getData().getProjectVOS().isEmpty()) {
            return Result.failed("请先填写项目经历再尝试投递该职位");
        }
        if (result.getData().getJobVOS().isEmpty()) {
            return Result.failed("请先填写工作/实习经历再尝试投递该职位");
        }

        return iResumeDeliveryService.saveResumeDelivery(positionId);
    }

    /**
     * 修改投递状态
     *
     * @param id     id
     * @param status 状态 1已查看2感兴趣3已拒绝
     * @return 响应
     */
    @PutMapping("/{id}/{status}")
    @PreAuthorize("hasAnyRole('recruiter')")
    public Result<String> modifyStatus(@PathVariable("id") Integer id,
                                       @PathVariable("status") Integer status) {
        return iResumeDeliveryService.modifyStatus(id, status);
    }


}
