package com.weijin.recruitment.service;

import com.weijin.recruitment.common.Result;
import com.weijin.recruitment.model.vo.count.EduCountVO;
import com.weijin.recruitment.model.vo.count.PositionMonthCountVO;
import com.weijin.recruitment.model.vo.count.StatCountVO;

import java.util.List;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/9/16 14:46
 */
public interface IStatService {

    /**
     * 统计数量统计
     * 统计求职者人数，招聘者人数，公司数量，职位数量
     *
     * @return 响应
     */
    Result<StatCountVO> queryStatNum();

    /**
     * 获取职位学历要求
     *
     * @return 响应
     */
    Result<EduCountVO> queryStatEdu();

    /**
     * 获取最近半年发布职位数量
     *
     * @return 响应
     */
    Result<List<PositionMonthCountVO>> queryStatPosition();

}
