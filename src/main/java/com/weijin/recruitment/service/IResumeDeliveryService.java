package com.weijin.recruitment.service;

import com.weijin.recruitment.model.entity.ResumeDelivery;
import com.baomidou.mybatisplus.extension.service.IService;
import com.weijin.recruitment.model.result.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author WeiJin
 * @since 2024-06-30
 */
public interface IResumeDeliveryService extends IService<ResumeDelivery> {


    /**
     * 投递简历
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
}
