package com.weijin.recruitment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.weijin.recruitment.converter.JobConverter;
import com.weijin.recruitment.model.entity.Job;
import com.weijin.recruitment.mapper.JobMapper;
import com.weijin.recruitment.model.from.job.JobFrom;
import com.weijin.recruitment.common.Result;
import com.weijin.recruitment.model.vo.job.JobVO;
import com.weijin.recruitment.service.IJobService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.weijin.recruitment.util.SecurityUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author WeiJin
 * @since 2024-06-30
 */
@Service
public class JobServiceImpl extends ServiceImpl<JobMapper, Job> implements IJobService {

    @Resource
    private JobConverter jobConverter;

    @Override
    public Result<String> saveJob(JobFrom jobFrom) {
        Job job = jobConverter.fromToEntity(jobFrom);
        int inserted = baseMapper.insert(job);
        return inserted > 0 ? Result.success("工作/实习经历保存成功") : Result.failed("工作/实现经历保存失败");
    }

    @Override
    public Result<String> modifyJob(JobFrom jobFrom) {
        Job job = jobConverter.fromToEntity(jobFrom);
        int updated = baseMapper.updateById(job);
        return updated > 0 ? Result.success("工作/实习经历修改成功") : Result.failed("工作/实现经历修改失败");
    }

    @Override
    public Result<String> removeJob(Integer id) {
        int deleted = baseMapper.deleteById(id);
        return deleted > 0 ? Result.success("工作/实习经历删除成功") : Result.failed("工作/实现经历删除失败");
    }

    @Override
    public Result<List<JobVO>> queryJob() {
        LambdaQueryWrapper<Job> wrapper = new LambdaQueryWrapper<Job>()
                .eq(Job::getUserId, SecurityUtil.getUserId());
        List<Job> jobs = baseMapper.selectList(wrapper);
        List<JobVO> jobVOS = jobConverter.listEntityToListVO(jobs);
        return !jobVOS.isEmpty() ? Result.success("工作/实习经历获取成功", jobVOS) : Result.failed("你暂时还没有工作/实习经历");
    }
}
