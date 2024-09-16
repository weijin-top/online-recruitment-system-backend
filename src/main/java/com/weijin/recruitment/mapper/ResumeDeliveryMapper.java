package com.weijin.recruitment.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.weijin.recruitment.model.entity.ResumeDelivery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.weijin.recruitment.model.vo.count.DeliveryCountVO;
import com.weijin.recruitment.model.vo.resumedelivery.DeliveryInfoVO;
import com.weijin.recruitment.model.vo.resumedelivery.ResumeDeliveryInfoVO;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author WeiJin
 * @since 2024-06-30
 */
public interface ResumeDeliveryMapper extends BaseMapper<ResumeDelivery> {
    /**
     * 分页获取简历投递信息
     *
     * @param page   分页
     * @param status 投递状态
     * @return 结果
     */
    IPage<DeliveryInfoVO> selectPageDeliveryInfo(IPage<DeliveryInfoVO> page, Integer status, Integer userId);

    /**
     * 根据用户id统计不同投递状态个数
     *
     * @param userId 用户id
     * @return 结果
     */
    DeliveryCountVO selectDeliveryCountByUserId(Integer userId);

    /**
     * 根据公司id获取求职者投递信息
     *
     * @param page         分页信息
     * @param education    学历
     * @param positionName 职位名称
     * @param companyId    公司id
     * @param status       投递状态
     * @return 结果
     */
    IPage<ResumeDeliveryInfoVO> selectPageResumeDeliveryInfo(IPage<ResumeDeliveryInfoVO> page, Integer education,
                                                             String positionName, Integer status, Integer companyId);

    /**
     * 根据公司id获取公司被投递情况
     *
     * @param companyId 公司id
     * @return 结果
     */
    DeliveryCountVO selectRecruiterQueryDeliveryCount(Integer companyId);
}
