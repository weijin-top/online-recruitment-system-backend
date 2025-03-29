package com.weijin.recruitment.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.weijin.recruitment.group.PositionGroup;
import com.weijin.recruitment.model.from.position.PositionFrom;
import com.weijin.recruitment.common.Result;
import com.weijin.recruitment.model.vo.position.PositionDetailVO;
import com.weijin.recruitment.model.vo.position.PositionSimpleVO;
import com.weijin.recruitment.model.vo.position.PositionVO;
import com.weijin.recruitment.service.IPositionService;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 职位管理
 *
 * @author WeiJin
 * @since 2024-06-30
 */
@RestController
@RequestMapping("/api/position")
public class PositionController {

    @Resource
    private IPositionService iPositionService;


    /**
     * 发布职位
     *
     * @param positionFrom 入参
     * @return 响应
     */
    @PostMapping
    @PreAuthorize("hasAnyRole('recruiter')")
    public Result<String> savePosition(@Validated(PositionGroup.SavePositionGroup.class) @RequestBody PositionFrom positionFrom) {
        return iPositionService.savePosition(positionFrom);
    }

    /**
     * 修改职位
     *
     * @param positionFrom 入参
     * @return 响应
     */
    @PutMapping
    @PreAuthorize("hasAnyRole('recruiter')")
    public Result<String> modifyPosition(@Validated(PositionGroup.ModifyPositionGroup.class) @RequestBody PositionFrom positionFrom) {
        return iPositionService.modifyPosition(positionFrom);
    }

    /**
     * 根据id查询职位
     *
     * @param id 职位id
     * @return 响应
     */
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('recruiter')")
    public Result<PositionVO> queryPositionById(@PathVariable("id") Integer id) {
        return iPositionService.queryPositionById(id);
    }

    /**
     * 审核职位
     *
     * @param id     职位id
     * @param status 状态 1通过2不通过3下架
     * @return 响应
     */
    @PutMapping("/audit/{id}/{status}")
    @PreAuthorize("hasAnyRole('admin')")
    public Result<String> auditPosition(@PathVariable("id") Integer id,
                                        @Min(value = 1, message = "审核状态只能是1-3")
                                        @Max(value = 3, message = "审核状态只能是1-3")
                                        @PathVariable("status") Integer status) {
        return iPositionService.auditPosition(id, status);
    }

    /**
     * 停止招聘
     * 用于招聘者下架该职位
     *
     * @param id 职位id
     * @return 响应
     */
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('recruiter')")
    public Result<String> cancelPosition(@PathVariable("id") Integer id) {
        return iPositionService.cancelPosition(id);
    }

    /**
     * 获取职位详情
     *
     * @param id 职位id
     * @return 响应
     */
    @GetMapping("/detail/{id}")
    @PreAuthorize("hasAnyRole('seeker','recruiter','admin')")
    public Result<PositionDetailVO> querySinge(@PathVariable("id") Integer id) {
        return iPositionService.querySinge(id);
    }

    /**
     * 分页获取职位
     *
     * @param pageNum  页码
     * @param pageSize 每页记录数
     * @param edu      学历要求
     * @param address  工作地点
     * @param type     职位类别
     * @param name     职位名称或公司名称
     * @param status   职位状态
     * @param orderBy  排序方式，默认0时间降序，1随机
     * @return 响应
     */
    @GetMapping("/page")
    @PreAuthorize("hasAnyRole('seeker','recruiter','admin')")
    public Result<IPage<PositionSimpleVO>> pagePosition(
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "18") Integer pageSize,
            @RequestParam(value = "edu", required = false) Integer edu,
            @RequestParam(value = "address", required = false) String address,
            @RequestParam(value = "type", required = false) Integer type,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "status", required = false) Integer status,
            @RequestParam(value = "orderBy", required = false, defaultValue = "0") Integer orderBy) {
        return iPositionService.pagePosition(pageNum, pageSize, edu, address, type, name, status, orderBy);
    }
}
