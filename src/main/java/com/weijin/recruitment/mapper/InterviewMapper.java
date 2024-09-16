package com.weijin.recruitment.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.weijin.recruitment.model.entity.Interview;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.weijin.recruitment.model.vo.interview.InterviewInfoVO;
import com.weijin.recruitment.model.vo.interview.InterviewResultVO;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author WeiJin
 * @since 2024-06-30
 */
public interface InterviewMapper extends BaseMapper<Interview> {

    /**
     * 分页获取某个用户的面试
     * @param page 分页信息
     * @param userId 用户id
     * @return 结果
     */
    IPage<InterviewInfoVO> selectPageInterviewInfo(IPage<InterviewInfoVO> page, Integer userId);

    /**
     * 根据公司id分页获取面试信息
     * @param page 分页信息
     * @param positionName 职位名称
     * @param status 状态
     * @param companyId 公司id
     * @return 结果
     */
    IPage<InterviewResultVO> selectPageInterviewResult(IPage<InterviewResultVO> page, String positionName,
                                                       Integer status, Integer companyId);
}
