package com.weijin.recruitment.service;

import com.weijin.recruitment.model.entity.Interview;
import com.baomidou.mybatisplus.extension.service.IService;
import com.weijin.recruitment.model.from.interview.ModifyInterviewFrom;
import com.weijin.recruitment.model.from.interview.SaveInterviewFrom;
import com.weijin.recruitment.model.result.Result;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author WeiJin
 * @since 2024-06-30
 */
public interface IInterviewService extends IService<Interview> {

    /**
     * 邀约面试
     *
     * @param saveInterviewFrom 入参
     * @return 响应
     */
    Result<String> saveInterview(SaveInterviewFrom saveInterviewFrom);

    /**
     * 通知面试结果
     *
     * @param modifyInterviewFrom 入参
     * @return 响应
     */
    Result<String> modifyInterview(ModifyInterviewFrom modifyInterviewFrom);
}
