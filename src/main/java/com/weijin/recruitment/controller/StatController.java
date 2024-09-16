package com.weijin.recruitment.controller;

import com.weijin.recruitment.common.Result;
import com.weijin.recruitment.model.vo.count.EduCountVO;
import com.weijin.recruitment.model.vo.count.PositionMonthCountVO;
import com.weijin.recruitment.model.vo.count.StatCountVO;
import com.weijin.recruitment.service.IStatService;
import jakarta.annotation.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/9/16 14:36
 */
@RestController
@RequestMapping("/api/stat")
public class StatController {

    @Resource
    private IStatService iStatService;

    /**
     * 统计数量统计
     * 统计求职者人数，招聘者人数，公司数量，职位数量
     *
     * @return 响应
     */
    @GetMapping("/num")
    @PreAuthorize("hasAnyRole('admin')")
    public Result<StatCountVO> queryStatNum() {
        return iStatService.queryStatNum();
    }

    /**
     * 获取职位学历要求
     *
     * @return 响应
     */
    @GetMapping("/edu")
    @PreAuthorize("hasAnyRole('admin')")
    public Result<EduCountVO> queryStatEdu() {
        return iStatService.queryStatEdu();
    }

    /**
     * 获取最近半年发布职位数量
     *
     * @return 响应
     */
    @GetMapping("/position")
    @PreAuthorize("hasAnyRole('admin')")
    public Result<List<PositionMonthCountVO>> queryStatPosition() {
        return iStatService.queryStatPosition();
    }
}
