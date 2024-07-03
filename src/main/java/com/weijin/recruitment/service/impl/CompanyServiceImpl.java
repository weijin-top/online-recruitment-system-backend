package com.weijin.recruitment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.weijin.recruitment.converter.CompanyConverter;
import com.weijin.recruitment.model.entity.Company;
import com.weijin.recruitment.mapper.CompanyMapper;
import com.weijin.recruitment.model.enumtype.RoleEnum;
import com.weijin.recruitment.model.from.company.CompanyFrom;
import com.weijin.recruitment.model.result.Result;
import com.weijin.recruitment.model.vo.company.CompanyVO;
import com.weijin.recruitment.service.ICompanyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.weijin.recruitment.util.SecurityUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author WeiJin
 * @since 2024-06-30
 */
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements ICompanyService {

    @Resource
    private CompanyConverter companyConverter;

    @Override
    public Result<String> saveCompany(CompanyFrom companyFrom) {
        Company company = companyConverter.fromToEntity(companyFrom);
        int inserted = baseMapper.insert(company);
        return inserted > 0 ? Result.success("公司认证成功，等待管理员审核") : Result.failed("公司认证失败");
    }

    @Override
    public Result<String> auditCompany(Integer id, Integer status) {
        Company company = new Company();
        company.setId(id);
        company.setStatus(status);
        int updated = baseMapper.updateById(company);
        return updated > 0 ? Result.success("操作成功") : Result.failed("操作失败");
    }

    @Override
    public Result<IPage<CompanyVO>> getCompanies(Integer pageNum, Integer pageSize, Integer status) {
        if (Objects.nonNull(status) && (status < 0 || status > 2)) {
            return Result.failed("审核状态只能是0-3");
        }
        IPage<Company> page = new Page<>(pageNum, pageSize);

        LambdaQueryWrapper<Company> wrapper = new LambdaQueryWrapper<Company>()
                .select(Company::getId, Company::getName, Company::getAddress,
                        Company::getIntro, Company::getLogo, Company::getStatus)
                .eq(Objects.nonNull(status), Company::getStatus, status);

        IPage<Company> companyPage = baseMapper.selectPage(page, wrapper);
        IPage<CompanyVO> companyVOPage = companyConverter.entityPageToVO(companyPage);
        return Result.success("查询成功", companyVOPage);
    }

    @Override
    public Result<CompanyVO> getSingle(Integer id) {
        //校验管理员不给企业信息id
        if (Objects.isNull(id) && Objects.equals(SecurityUtil.getRole(), RoleEnum.getRole(3))) {
            return Result.failed("企业信息id不能为空");
        }
        LambdaQueryWrapper<Company> wrapper = new LambdaQueryWrapper<Company>()
                .select(Company::getId, Company::getName, Company::getAddress,
                        Company::getIntro, Company::getLogo, Company::getStatus)
                .eq(Objects.nonNull(id) && Objects.equals(SecurityUtil.getRole(), RoleEnum.getRole(3)),
                        Company::getId, id)
                .eq(Objects.equals(SecurityUtil.getRole(), RoleEnum.getRole(2)),
                        Company::getUserId, SecurityUtil.getUserId());
        Company company = baseMapper.selectOne(wrapper);
        CompanyVO companyVO = companyConverter.entityToVO(company);

        return Objects.nonNull(companyVO) ? Result.success("查询成功", companyVO) : Result.failed("暂时没有企业信息");
    }


}
