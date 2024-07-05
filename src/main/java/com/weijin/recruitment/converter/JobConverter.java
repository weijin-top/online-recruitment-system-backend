package com.weijin.recruitment.converter;

import com.weijin.recruitment.model.entity.Job;
import com.weijin.recruitment.model.from.job.JobFrom;
import com.weijin.recruitment.model.vo.job.JobVO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/7/5 17:37
 */
@Component
@Mapper(componentModel = "spring")
public interface JobConverter {

    Job fromToEntity(JobFrom jobFrom);

    JobVO entityToVo(Job job);

    List<JobVO> listEntityToListVO(List<Job> list);
}
