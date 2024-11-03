package com.weijin.recruitment.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.weijin.recruitment.model.entity.Position;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.weijin.recruitment.model.vo.count.EduCountVO;
import com.weijin.recruitment.model.vo.count.PositionMonthCountVO;
import com.weijin.recruitment.model.vo.position.PositionDetailVO;
import com.weijin.recruitment.model.vo.position.PositionSimpleVO;

import java.util.List;

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
    PositionDetailVO selectPositionDetailById(Integer id, Integer userId);

    /**
     * 分页获取职位信息
     *
     * @param page      分页信息
     * @param edu       学历
     * @param address   地址
     * @param type      岗位类别
     * @param name      公司或岗位名称
     * @param status    职位状态
     * @param companyId 公司id
     * @return 结果
     */
    IPage<PositionSimpleVO> pagePosition(IPage<PositionSimpleVO> page, Integer edu, String address, Integer type,
                                         String name, Integer status, Integer companyId,Integer orderBy);

    /**
     * 查询再招职位数量
     *
     * @return 结果
     */
    Integer selectOpenPosition();

    /**
     * 获取职位学历人数
     *
     * @return 结果
     */
    EduCountVO selectStatEdu();

    /**
     * 查询最近六个发布的岗位数量
     *
     * @return 结果
     */
    List<PositionMonthCountVO> selectStatPosition();

}
