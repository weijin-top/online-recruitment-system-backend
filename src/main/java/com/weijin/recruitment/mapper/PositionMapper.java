package com.weijin.recruitment.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.weijin.recruitment.model.entity.Position;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.weijin.recruitment.model.vo.position.PositionDetailVO;
import com.weijin.recruitment.model.vo.position.PositionSimpleVO;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author WeiJin
 * @since 2024-06-30
 */
public interface PositionMapper extends BaseMapper<Position> {

    /**
     * 根据职位id获取职位详情
     *
     * @param id 职位id
     * @return 结果
     */
    PositionDetailVO selectPositionDetailById(Integer id);

    /**
     * 分页获取职位信息
     * @param page 分页信息
     * @param edu 学历
     * @param address 地址
     * @param type 岗位类别
     * @param name 公司或岗位名称
     * @return 结果
     */
    IPage<PositionSimpleVO> pagePosition(IPage<PositionSimpleVO> page, Integer edu, String address, Integer type, String name);

}
