package com.weijin.recruitment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.weijin.recruitment.mapper.CompanyMapper;
import com.weijin.recruitment.mapper.PositionMapper;
import com.weijin.recruitment.model.entity.Company;
import com.weijin.recruitment.model.entity.Position;
import com.weijin.recruitment.model.entity.ResumeDelivery;
import com.weijin.recruitment.mapper.ResumeDeliveryMapper;
import com.weijin.recruitment.common.Result;
import com.weijin.recruitment.model.vo.count.DeliveryCountVO;
import com.weijin.recruitment.model.vo.resumedelivery.DeliveryInfoVO;
import com.weijin.recruitment.model.vo.resumedelivery.ResumeDeliveryInfoVO;
import com.weijin.recruitment.service.IResumeDeliveryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.weijin.recruitment.util.SecurityUtil;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class ResumeDeliveryServiceImpl extends ServiceImpl<ResumeDeliveryMapper, ResumeDelivery> implements IResumeDeliveryService {

    @Resource
    private ResumeDeliveryMapper resumeDeliveryMapper;
    @Resource
    private PositionMapper positionMapper;
    @Resource
    private CompanyMapper companyMapper;

    @Override
    public Result<String> saveResumeDelivery(Integer positionId) {

        Position position = positionMapper.selectById(positionId);
        if (Objects.isNull(position) || position.getStatus() != 1) {
            return Result.failed("投递失败，该职位已下架");
        }
        LambdaQueryWrapper<ResumeDelivery> wrapper = new LambdaQueryWrapper<ResumeDelivery>()
                .eq(ResumeDelivery::getPositionId, positionId)
                .eq(ResumeDelivery::getUserId, SecurityUtil.getUserId());
        ResumeDelivery dbResumeDelivery = resumeDeliveryMapper.selectOne(wrapper);

        if (Objects.nonNull(dbResumeDelivery)) {
            return Result.failed("投递失败，不可重复投递");
        }

        ResumeDelivery resumeDelivery = new ResumeDelivery();
        resumeDelivery.setPositionId(positionId);
        resumeDelivery.setUserId(SecurityUtil.getUserId());

        int inserted = resumeDeliveryMapper.insert(resumeDelivery);
        return inserted > 0 ? Result.success("投递成功") : Result.failed("投递失败");
    }

    @Override
    public Result<String> modifyStatus(Integer id, Integer status) {
        if (status <= 0 || status > 2) {
            return Result.failed("状态只能是1-2");
        }
        ResumeDelivery dbResumeDelivery = baseMapper.selectById(id);
        if (Objects.isNull(dbResumeDelivery)) {
            return Result.failed("该投递记录不存在");
        }

        if (Objects.equals(dbResumeDelivery.getStatus(), status)) {
            return Result.failed("无需更改，状态已存在");
        }
        ResumeDelivery resumeDelivery = new ResumeDelivery();
        resumeDelivery.setId(id);
        resumeDelivery.setStatus(status);

        int updated = resumeDeliveryMapper.updateById(resumeDelivery);
        return updated > 0 ? Result.success("操作成功") : Result.failed("操作失败");
    }
    @Override
    public Result<IPage<DeliveryInfoVO>> queryDeliveryInfo(Integer pageNum, Integer pageSize, Integer status) {
        if (Objects.nonNull(status) && (status < 0 || status > 3)) {
            return Result.failed("投递状态只能是0-3");
        }
        IPage<DeliveryInfoVO> page = new Page<>(pageNum, pageSize);
        page = baseMapper.selectPageDeliveryInfo(page, status, SecurityUtil.getUserId());
        return Result.success("获取成功", page);
    }

    @Override
    public Result<DeliveryCountVO> queryDeliveryCount() {
        DeliveryCountVO countVO = baseMapper.selectDeliveryCountByUserId(SecurityUtil.getUserId());
        return Result.success("查询成功", countVO);
    }

    @Override
    public Result<IPage<ResumeDeliveryInfoVO>> queryResumeDeliveryInfo(Integer pageNum, Integer pageSize,
                                                                       Integer education, String positionName, Integer status) {
        //先获取自己的公司信息
        LambdaQueryWrapper<Company> wrapper = new LambdaQueryWrapper<Company>().eq(Company::getUserId, SecurityUtil.getUserId());
        Company company = companyMapper.selectOne(wrapper);
        if (Objects.isNull(company)) {
            return Result.failed("请先完善企业信息");
        }
        IPage<ResumeDeliveryInfoVO> page = new Page<>(pageNum, pageSize);
        page = baseMapper.selectPageResumeDeliveryInfo(page, education, positionName, status, company.getId());
        return Result.success("获取成功", page);
    }

    @Override
    public Result<DeliveryCountVO> recruiterQueryDeliveryCount() {
        // 获取自己的公司信息
        LambdaQueryWrapper<Company> wrapper = new LambdaQueryWrapper<Company>().eq(Company::getUserId, SecurityUtil.getUserId());
        Company company = companyMapper.selectOne(wrapper);
        if (Objects.isNull(company)) {
            return Result.failed("请先完善公司信息");
        }
        DeliveryCountVO countVO = baseMapper.selectRecruiterQueryDeliveryCount(company.getId());
        return Result.success("获取成功", countVO);
    }
}
