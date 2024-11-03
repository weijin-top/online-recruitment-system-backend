package com.weijin.recruitment.mapper;

import com.weijin.recruitment.model.entity.Company;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author WeiJin
 * @since 2024-06-30
 */
public interface CompanyMapper extends BaseMapper<Company> {

    /**
     * 根据职位id获取公司信息
     * @param id 职位id
     * @return 结果
     */
    Company selectCompanyByPositionId(Integer id);
}
