package com.weijin.recruitment.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.weijin.recruitment.model.entity.ResumeDelivery;
import com.baomidou.mybatisplus.extension.service.IService;
import com.weijin.recruitment.common.Result;
import com.weijin.recruitment.model.vo.count.DeliveryCountVO;
import com.weijin.recruitment.model.vo.resumedelivery.DeliveryInfoVO;
import com.weijin.recruitment.model.vo.resumedelivery.ResumeDeliveryInfoVO;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author WeiJin
 * @since 2024-06-30
 */
public interface IResumeDeliveryService extends IService<ResumeDelivery> {


    /**
     * 投递简历
     *
     * @param positionId 职位id
     * @return 响应
     */
    Result<String> saveResumeDelivery(Integer positionId);

    /**
     * 修改投递状态
     *
     * @param id     id
     * @param status 状态 1已查看2感兴趣3已拒绝
     * @return 响应
     */
    Result<String> modifyStatus(Integer id, Integer status);

    /**
     * 分页获取我投递的简历
     *
     * @param pageNum  页码
     * @param pageSize 每页记录数
     * @param status   状态
     * @return 响应
     */
    Result<IPage<DeliveryInfoVO>> queryDeliveryInfo(Integer pageNum, Integer pageSize, Integer status);

    /**
     * 获取本人投递不同状态个数
     *
     * @return 响应
     */
    Result<DeliveryCountVO> queryDeliveryCount();


    /**
     * 招聘者分页获取求职者投递简历信息
     *
     * @param pageNum      页码
     * @param pageSize     每页记录数
     * @param education    学历
     * @param positionName 职位名称
     * @param status       投递状态
     * @return 响应
     */
    Result<IPage<ResumeDeliveryInfoVO>> queryResumeDeliveryInfo(Integer pageNum, Integer pageSize, Integer education,
                                                                String positionName, Integer status);

    /**
     * 招聘者获取本公司被投递不同状态个数
     *
     * @return 响应
     */
    Result<DeliveryCountVO> recruiterQueryDeliveryCount();


}
