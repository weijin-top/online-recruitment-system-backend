package com.weijin.recruitment.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.weijin.recruitment.common.Result;
import com.weijin.recruitment.model.vo.info.ResumeVO;
import com.weijin.recruitment.model.vo.count.DeliveryCountVO;
import com.weijin.recruitment.model.vo.resumedelivery.DeliveryInfoVO;
import com.weijin.recruitment.model.vo.resumedelivery.ResumeDeliveryInfoVO;
import com.weijin.recruitment.service.IInfoService;
import com.weijin.recruitment.service.IResumeDeliveryService;
import com.weijin.recruitment.utils.SecurityUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
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
@Slf4j
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
        // 未完善简历不能投递简历
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

    /**
     * 分页获取我投递的简历
     *
     * @param pageNum  页码
     * @param pageSize 每页记录数
     * @param status   状态
     * @return 响应
     */
    @GetMapping
    @PreAuthorize("hasAnyRole('seeker')")
    public Result<IPage<DeliveryInfoVO>> queryDeliveryInfo(@RequestParam(value = "pageNum", defaultValue = "1", required = false) Integer pageNum,
                                                           @RequestParam(value = "pageSize", defaultValue = "20", required = false) Integer pageSize,
                                                           @RequestParam(value = "status", required = false) Integer status) {
        return iResumeDeliveryService.queryDeliveryInfo(pageNum, pageSize, status);
    }

    /**
     * 获取本人投递不同状态个数
     *
     * @return 响应
     */
    @GetMapping("/count")
    @PreAuthorize("hasAnyRole('seeker')")
    public Result<DeliveryCountVO> queryDeliveryCount() {
        return iResumeDeliveryService.queryDeliveryCount();
    }

    /**
     * 招聘者获取本公司被投递不同状态个数
     *
     * @return 响应
     */
    @GetMapping("/recruiter/count")
    @PreAuthorize("hasAnyRole('recruiter')")
    public Result<DeliveryCountVO> recruiterQueryDeliveryCount() {
        return iResumeDeliveryService.recruiterQueryDeliveryCount();
    }

    /**
     * 招聘者分页获取求职者投递简历信息
     *
     * @param pageNum      页码
     * @param pageSize     每页记录数
     * @param education    学历
     * @param positionName 职位名称
     * @param status       投递状态
     * @return 响应
     */
    @GetMapping("/delivery")
    @PreAuthorize("hasAnyRole('recruiter')")
    public Result<IPage<ResumeDeliveryInfoVO>> queryResumeDeliveryInfo(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                                                       @RequestParam(value = "pageSize", defaultValue = "20", required = false) Integer pageSize,
                                                                       @RequestParam(value = "education", required = false) Integer education,
                                                                       @RequestParam(value = "positionName", required = false) String positionName,
                                                                       @RequestParam(value = "status", required = false) Integer status) {
        return iResumeDeliveryService.queryResumeDeliveryInfo(pageNum, pageSize, education, positionName, status);
    }

}
