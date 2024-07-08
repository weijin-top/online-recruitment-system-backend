package com.weijin.recruitment.controller;

import com.weijin.recruitment.group.PositionGroup;
import com.weijin.recruitment.model.from.position.PositionFrom;
import com.weijin.recruitment.model.result.Result;
import com.weijin.recruitment.service.IPositionService;
import com.weijin.recruitment.service.IPostService;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

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
    public Result<String> savePosition(@Validated(PositionGroup.SavePositionGroup.class) PositionFrom positionFrom) {
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
    public Result<String> modifyPosition(@Validated(PositionGroup.ModifyPositionGroup.class) PositionFrom positionFrom) {
        return iPositionService.modifyPosition(positionFrom);
    }

    /**
     * 审核职位
     * @param id 职位id
     * @param status 状态 1通过2不通过3下架
     * @return 响应
     */
    @PutMapping("/audit/{id}/{status}")
    @PreAuthorize("hasAnyRole('admin')")
    public Result<String> auditPosition(@PathVariable("id") Integer id,
                                        @Min(value = 1, message = "审核状态只能是1-3")
                                        @Max(value = 3, message = "审核状态只能是1-3")
                                        @PathVariable("status") Integer status) {
        return iPositionService.auditPosition(id,status);
    }

}
