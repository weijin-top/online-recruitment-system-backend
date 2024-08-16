package com.weijin.recruitment.service.impl;

import com.weijin.recruitment.converter.InterviewConverter;
import com.weijin.recruitment.mapper.ResumeDeliveryMapper;
import com.weijin.recruitment.model.entity.Interview;
import com.weijin.recruitment.mapper.InterviewMapper;
import com.weijin.recruitment.model.entity.ResumeDelivery;
import com.weijin.recruitment.model.from.interview.ModifyInterviewFrom;
import com.weijin.recruitment.model.from.interview.SaveInterviewFrom;
import com.weijin.recruitment.model.result.Result;
import com.weijin.recruitment.service.IInterviewService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private InterviewMapper interviewMapper;
    @Resource
    private ResumeDeliveryMapper resumeDeliveryMapper;

    @Override
    @Transactional
    public Result<String> saveInterview(SaveInterviewFrom saveInterviewFrom) {
        //修改简历投递表中状态
        ResumeDelivery resumeDelivery = new ResumeDelivery();
        resumeDelivery.setId(saveInterviewFrom.getRdId());
        resumeDelivery.setStatus(4);
        int result = resumeDeliveryMapper.updateById(resumeDelivery);
        //保存面试邀约表
        Interview interview = interviewConverter.saveFromToEntity(saveInterviewFrom);
        result += interviewMapper.insert(interview);
        return result == 2 ? Result.success("邀约成功") : Result.failed("邀约失败");
    }

    @Override
    public Result<String> modifyInterview(ModifyInterviewFrom modifyInterviewFrom) {
        Interview interview = interviewConverter.modifyFromToEntity(modifyInterviewFrom);
        int updated = interviewMapper.updateById(interview);
        return updated > 0 ? Result.success("操作成功") : Result.failed("操作失败");
    }
}
