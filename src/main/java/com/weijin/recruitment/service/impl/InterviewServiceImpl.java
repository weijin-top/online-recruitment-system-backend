package com.weijin.recruitment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.weijin.recruitment.converter.InterviewConverter;
import com.weijin.recruitment.mapper.CompanyMapper;
import com.weijin.recruitment.mapper.ResumeDeliveryMapper;
import com.weijin.recruitment.model.entity.Company;
import com.weijin.recruitment.model.entity.Interview;
import com.weijin.recruitment.mapper.InterviewMapper;
import com.weijin.recruitment.model.entity.ResumeDelivery;
import com.weijin.recruitment.model.from.interview.ModifyInterviewFrom;
import com.weijin.recruitment.model.from.interview.SaveInterviewFrom;
import com.weijin.recruitment.common.Result;
import com.weijin.recruitment.model.vo.interview.InterviewInfoVO;
import com.weijin.recruitment.model.vo.interview.InterviewResultDetailVO;
import com.weijin.recruitment.model.vo.interview.InterviewResultVO;
import com.weijin.recruitment.model.vo.interview.InterviewVO;
import com.weijin.recruitment.model.vo.resumedelivery.ResumeDeliveryInfoVO;
import com.weijin.recruitment.service.IInterviewService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.weijin.recruitment.util.SecurityUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class InterviewServiceImpl extends ServiceImpl<InterviewMapper, Interview> implements IInterviewService {

    @Resource
    private InterviewConverter interviewConverter;
    @Resource
    private ResumeDeliveryMapper resumeDeliveryMapper;
    @Resource
    private CompanyMapper companyMapper;

    @Override
    @Transactional
    public Result<String> saveInterview(SaveInterviewFrom saveInterviewFrom) {
        ResumeDelivery dbResumeDelivery = resumeDeliveryMapper.selectById(saveInterviewFrom.getRdId());
        if (Objects.isNull(dbResumeDelivery)) {
            return Result.failed("该投递记录不存在");
        }

        if (Objects.equals(dbResumeDelivery.getStatus(), 3)) {
            return Result.failed("不能重复邀约面试");
        }
        //修改简历投递表中状态
        ResumeDelivery resumeDelivery = new ResumeDelivery();
        resumeDelivery.setId(saveInterviewFrom.getRdId());
        resumeDelivery.setStatus(3);
        int result = resumeDeliveryMapper.updateById(resumeDelivery);
        //保存面试邀约表
        Interview interview = interviewConverter.saveFromToEntity(saveInterviewFrom);
        result += baseMapper.insert(interview);
        return result == 2 ? Result.success("邀约成功") : Result.failed("邀约失败");
    }

    @Override
    public Result<String> modifyInterview(ModifyInterviewFrom modifyInterviewFrom) {
        Interview interview = interviewConverter.modifyFromToEntity(modifyInterviewFrom);
        int updated = baseMapper.updateById(interview);
        return updated > 0 ? Result.success("操作成功") : Result.failed("操作失败");
    }

    @Override
    public Result<IPage<InterviewInfoVO>> queryInterviewInfo(Integer pageNum, Integer pageSize) {
        IPage<InterviewInfoVO> page = new Page<>(pageNum, pageSize);
        page = baseMapper.selectPageInterviewInfo(page, SecurityUtil.getUserId());
        return Result.success("查询成功", page);
    }

    @Override
    public Result<InterviewVO> queryInterviewById(Integer id) {
        Interview interview = baseMapper.selectById(id);
        InterviewVO interviewVO = interviewConverter.entityToVO(interview);
        return Result.success("查询成功", interviewVO);
    }

    @Override
    public Result<IPage<InterviewResultVO>> queryInterviewResult(Integer pageNum, Integer pageSize, String positionName, Integer status) {
        //先获取自己的公司信息
        LambdaQueryWrapper<Company> wrapper = new LambdaQueryWrapper<Company>().eq(Company::getUserId, SecurityUtil.getUserId());
        Company company = companyMapper.selectOne(wrapper);
        if (Objects.isNull(company)) {
            return Result.failed("请先完善企业信息");
        }
        IPage<InterviewResultVO> page = new Page<>(pageNum, pageSize);
        page = baseMapper.selectPageInterviewResult(page, positionName, status, company.getId());
        return Result.success("获取查询成功", page);
    }

    @Override
    public Result<InterviewResultDetailVO> queryResultDetail(Integer id) {
        LambdaQueryWrapper<Interview> wrapper = new LambdaQueryWrapper<Interview>()
                .select(Interview::getId, Interview::getResultRemark, Interview::getStatus)
                .eq(Interview::getId, id);
        Interview interview = baseMapper.selectOne(wrapper);
        if (Objects.isNull(interview)) {
            return Result.failed("该面试结果不存在");
        }
        InterviewResultDetailVO detailVO = interviewConverter.entityToResultDetailVO(interview);
        return Result.success("查询成功", detailVO);
    }
}
