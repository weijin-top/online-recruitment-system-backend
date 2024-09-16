package com.weijin.recruitment.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.weijin.recruitment.model.entity.Company;
import com.baomidou.mybatisplus.extension.service.IService;
import com.weijin.recruitment.model.from.company.CompanyFrom;
import com.weijin.recruitment.common.Result;
import com.weijin.recruitment.model.vo.company.CompanyVO;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author WeiJin
 * @since 2024-06-30
 */
public interface ICompanyService extends IService<Company> {

    /**
     * 添加公司
     *
     * @param companyFrom 入参
     * @return 响应
     */
    Result<String> saveCompany(CompanyFrom companyFrom);

    /**
     * 审核公司
     *
     * @param id     公司id
     * @param status 状态 1通过 2未通过
     * @return 响应
     */
    Result<String> auditCompany(Integer id, Integer status);

    /**
     * 分页获取公司列表
     *
     * @param pageNum  页码
     * @param pageSize 每页记录数
     * @param status   公司审核状态
     * @param name     公司名称
     * @return 响应
     */
    Result<IPage<CompanyVO>> queryCompanies(Integer pageNum, Integer pageSize, Integer status,String name);

    /**
     * 获取单个公司信息
     *
     * @param id 公司id
     * @return 响应
     */
    Result<CompanyVO> querySingle(Integer id);

    /**
     * 修改公司信息
     * @param companyFrom 入参
     * @return 响应
     */
    Result<String> modifyCompany(CompanyFrom companyFrom);
}
