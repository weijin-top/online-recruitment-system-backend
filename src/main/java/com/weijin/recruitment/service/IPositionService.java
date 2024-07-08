package com.weijin.recruitment.service;

import com.weijin.recruitment.model.entity.Position;
import com.baomidou.mybatisplus.extension.service.IService;
import com.weijin.recruitment.model.from.position.PositionFrom;
import com.weijin.recruitment.model.result.Result;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author WeiJin
 * @since 2024-06-30
 */
public interface IPositionService extends IService<Position> {

    /**
     * 发布职位
     *
     * @param positionFrom 入参
     * @return 响应
     */
    Result<String> savePosition(PositionFrom positionFrom);

    /**
     * 修改职位
     *
     * @param positionFrom 入参
     * @return 响应
     */
    Result<String> modifyPosition(PositionFrom positionFrom);

    /**
     * 审核职位
     * @param id 职位id
     * @param status 状态 1通过2不通过3下架
     * @return 响应
     */
    Result<String> auditPosition(Integer id, Integer status);
}
