package com.weijin.recruitment.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.weijin.recruitment.model.entity.Interview;
import com.baomidou.mybatisplus.extension.service.IService;
import com.weijin.recruitment.model.from.interview.ModifyInterviewFrom;
import com.weijin.recruitment.model.from.interview.SaveInterviewFrom;
import com.weijin.recruitment.common.Result;
import com.weijin.recruitment.model.vo.interview.InterviewInfoVO;
import com.weijin.recruitment.model.vo.interview.InterviewResultDetailVO;
import com.weijin.recruitment.model.vo.interview.InterviewResultVO;
import com.weijin.recruitment.model.vo.interview.InterviewVO;

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

    /**
     * 分页获取我的面试
     *
     * @param pageNum  页码
     * @param pageSize 每页记录数
     * @return 响应
     */
    Result<IPage<InterviewInfoVO>> queryInterviewInfo(Integer pageNum, Integer pageSize);

    /**
     * 根据面试id获取面试进度
     *
     * @param id 面试id
     * @return 响应
     */
    Result<InterviewVO> queryInterviewById(Integer id);

    /**
     * 招聘者分页获取本公司面试信息
     *
     * @param pageNum      页码
     * @param pageSize     每页记录数
     * @param positionName 职位名称
     * @param status       状态
     * @return 响应
     */
    Result<IPage<InterviewResultVO>> queryInterviewResult(Integer pageNum, Integer pageSize, String positionName, Integer status);

    /**
     * 根据id获取面试结果
     *
     * @param id id
     * @return 响应
     */
    Result<InterviewResultDetailVO> queryResultDetail(Integer id);
}
