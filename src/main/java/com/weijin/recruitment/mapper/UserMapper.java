package com.weijin.recruitment.mapper;

import com.weijin.recruitment.model.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.weijin.recruitment.model.vo.count.StatCountVO;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author WeiJin
 * @since 2024-06-30
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 统计求职者人数和招聘者人数
     * @return 结果
     */
    StatCountVO selectStatNum();
}
