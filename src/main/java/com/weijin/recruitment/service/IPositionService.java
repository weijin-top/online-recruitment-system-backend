package com.weijin.recruitment.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.weijin.recruitment.model.entity.Position;
import com.baomidou.mybatisplus.extension.service.IService;
import com.weijin.recruitment.model.from.position.PositionFrom;
import com.weijin.recruitment.common.Result;
import com.weijin.recruitment.model.vo.position.PositionDetailVO;
import com.weijin.recruitment.model.vo.position.PositionSimpleVO;
import com.weijin.recruitment.model.vo.position.PositionVO;

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
     *
     * @param id     职位id
     * @param status 状态 1通过2不通过3下架
     * @return 响应
     */
    Result<String> auditPosition(Integer id, Integer status);

    /**
     * 停止招聘
     * 用于招聘者下架该职位
     *
     * @param id 职位id
     * @return 响应
     */
    Result<String> cancelPosition(Integer id);

    /**
     * 获取职位详情
     *
     * @param id 职位id
     * @return 响应
     */
    Result<PositionDetailVO> querySinge(Integer id);

    /**
     * 分页获取职位
     *
     * @param pageNum  页码
     * @param pageSize 每页记录数
     * @param edu      学历要求
     * @param address  工作地点
     * @param type     职位类别
     * @param name     职位名称或公司名称
     * @param status   职位状态
     * @return 响应
     */
    Result<IPage<PositionSimpleVO>> pagePosition(Integer pageNum, Integer pageSize, Integer edu,
                                                 String address, Integer type, String name, Integer status);


    /**
     *
     * 根据id查询职位
     * @param id 职位id
     * @return 响应
     */
    Result<PositionVO> queryPositionById(Integer id);
}
