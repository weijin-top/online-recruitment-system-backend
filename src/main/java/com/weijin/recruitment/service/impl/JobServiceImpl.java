package com.weijin.recruitment.service.impl;

import com.weijin.recruitment.model.entity.Job;
import com.weijin.recruitment.mapper.JobMapper;
import com.weijin.recruitment.service.IJobService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author WeiJin
 * @since 2024-06-30
 */
@Service
public class JobServiceImpl extends ServiceImpl<JobMapper, Job> implements IJobService {

}
