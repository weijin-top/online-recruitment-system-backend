package com.weijin.recruitment.converter;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.weijin.recruitment.model.entity.Company;
import com.weijin.recruitment.model.from.company.CompanyFrom;
import com.weijin.recruitment.model.vo.company.CompanyVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/7/3 15:05
 */
@Component
@Mapper(componentModel = "spring")
public interface CompanyConverter {

    Company fromToEntity(CompanyFrom companyFrom);

    Page<CompanyVO> entityPageToVO(IPage<Company> page);

    @Mapping(source = "nickname", target = "nickname")
    CompanyVO entityToVO(Company company);
}
