package com.weijin.recruitment.service;

import com.weijin.recruitment.model.entity.Job;
import com.baomidou.mybatisplus.extension.service.IService;
import com.weijin.recruitment.model.from.job.JobFrom;
import com.weijin.recruitment.model.result.Result;
import com.weijin.recruitment.model.vo.job.JobVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author WeiJin
 * @since 2024-06-30
 */
public interface IJobService extends IService<Job> {

    /**
     * 添加工作/实习经历
     *
     * @param jobFrom 入参
     * @return 响应
     */
    Result<String> saveJob(JobFrom jobFrom);

    /**
     * 修改工作/实习经历
     *
     * @param jobFrom 入参
     * @return 响应
     */
    Result<String> modifyJob(JobFrom jobFrom);

    /**
     * 删除工作/实习经历
     *
     * @param id 工作/实现经历id
     * @return 响应
     */
    Result<String> removeJob(Integer id);

    /**
     * 获取本人工作/实现经历
     *
     * @return 响应
     */
    Result<List<JobVO>> queryJob();
}
