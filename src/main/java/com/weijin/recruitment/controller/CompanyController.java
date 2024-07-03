package com.weijin.recruitment.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.weijin.recruitment.model.from.company.CompanyFrom;
import com.weijin.recruitment.model.result.Result;
import com.weijin.recruitment.model.vo.company.CompanyVO;
import com.weijin.recruitment.service.ICompanyService;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 公司管理
 *
 * @author WeiJin
 * @since 2024-06-30
 */
@RestController
@RequestMapping("/api/company")
public class CompanyController {

    @Resource
    private ICompanyService iCompanyService;

    /**
     * 添加公司
     *
     * @param companyFrom 入参
     * @return 相应
     */
    @PostMapping
    @PreAuthorize("hasAnyRole('recruiter')")
    public Result<String> saveCompany(@Validated @RequestBody CompanyFrom companyFrom) {
        return iCompanyService.saveCompany(companyFrom);
    }


    /**
     * 审核公司
     *
     * @param id     公司id
     * @param status 状态 1通过 2未通过
     * @return 响应
     */
    @PutMapping("/audit/{id}/{status}")
    @PreAuthorize("hasAnyRole('admin')")
    public Result<String> auditCompany(@PathVariable("id") Integer id,
                                       @Min(value = 1, message = "审核状态只能是1或2")
                                       @Max(value = 2, message = "审核状态只能是1或2")
                                       @PathVariable("status") Integer status) {
        return iCompanyService.auditCompany(id, status);
    }


    /**
     * 分页获取公司列表
     *
     * @param pageNum  页码
     * @param pageSize 每页记录数
     * @param status   公司审核状态
     * @return 响应
     */
    @GetMapping("/companies")
    @PreAuthorize("hasAnyRole('admin')")
    public Result<IPage<CompanyVO>> getCompanies(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                                 @RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize,
                                                 @Min(value = 0, message = "审核状态只能是0-2")
                                                 @Max(value = 2, message = "审核状态只能是0-2")
                                                 @RequestParam(value = "status", required = false) Integer status) {
        return iCompanyService.getCompanies(pageNum, pageSize, status);
    }

    /**
     * 获取单个公司信息
     * 公司id可选，管理员用户审核时查看，就需要填，招聘者，维护自己公司，就不需要填，直接根据用户id去获取
     *
     * @param id 公司id
     * @return 响应
     */
    @GetMapping("/single")
    @PreAuthorize("hasAnyRole('recruiter','admin')")
    public Result<CompanyVO> getSingle(@RequestParam(value = "id", required = false) Integer id) {
        return iCompanyService.getSingle(id);
    }

}
