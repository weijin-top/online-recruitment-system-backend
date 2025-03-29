package com.weijin.recruitment.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.weijin.recruitment.model.entity.Info;
import com.weijin.recruitment.model.vo.info.ResumeVO;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/7/3 22:51
 */
public interface InfoMapper extends BaseMapper<Info> {
    /**
     * 获取简历基本信息
     *
     * @param userId 用户id
     * @return 结果
     */
    ResumeVO selectResume(Integer userId);
}
