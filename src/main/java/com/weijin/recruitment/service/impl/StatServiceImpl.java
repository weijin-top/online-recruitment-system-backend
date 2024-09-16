package com.weijin.recruitment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.weijin.recruitment.common.Result;
import com.weijin.recruitment.mapper.CompanyMapper;
import com.weijin.recruitment.mapper.PositionMapper;
import com.weijin.recruitment.mapper.UserMapper;
import com.weijin.recruitment.model.entity.Company;
import com.weijin.recruitment.model.vo.count.EduCountVO;
import com.weijin.recruitment.model.vo.count.PositionMonthCountVO;
import com.weijin.recruitment.model.vo.count.StatCountVO;
import com.weijin.recruitment.service.IStatService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/9/16 14:47
 */
@Service
public class StatServiceImpl implements IStatService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private PositionMapper positionMapper;
    @Resource
    private CompanyMapper companyMapper;

    @Override
    public Result<StatCountVO> queryStatNum() {
        StatCountVO statCountVO = userMapper.selectStatNum();
        statCountVO.setCompanyCount(
                companyMapper.selectCount(new LambdaQueryWrapper<Company>().eq(Company::getStatus,1))
                .intValue());
        statCountVO.setPositionCount(positionMapper.selectOpenPosition());
        return Result.success("查询成功",statCountVO);
    }

    @Override
    public Result<EduCountVO> queryStatEdu() {
       EduCountVO eduCountVO = positionMapper.selectStatEdu();
        return Result.success("查询成功",eduCountVO);
    }

    @Override
    public Result<List<PositionMonthCountVO>> queryStatPosition() {
       List<PositionMonthCountVO> list =  positionMapper.selectStatPosition();
        return Result.success("查询成功",list);
    }
}
