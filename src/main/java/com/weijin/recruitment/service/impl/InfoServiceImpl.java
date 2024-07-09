package com.weijin.recruitment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.weijin.recruitment.converter.EducationConverter;
import com.weijin.recruitment.converter.InfoConverter;
import com.weijin.recruitment.converter.JobConverter;
import com.weijin.recruitment.converter.ProjectConverter;
import com.weijin.recruitment.mapper.EducationMapper;
import com.weijin.recruitment.mapper.InfoMapper;
import com.weijin.recruitment.mapper.JobMapper;
import com.weijin.recruitment.mapper.ProjectMapper;
import com.weijin.recruitment.model.entity.Education;
import com.weijin.recruitment.model.entity.Info;
import com.weijin.recruitment.model.entity.Job;
import com.weijin.recruitment.model.entity.Project;
import com.weijin.recruitment.model.from.info.InfoFrom;
import com.weijin.recruitment.model.result.Result;
import com.weijin.recruitment.model.vo.education.EducationVO;
import com.weijin.recruitment.model.vo.info.InfoVO;
import com.weijin.recruitment.model.vo.info.ResumeVO;
import com.weijin.recruitment.service.IInfoService;
import com.weijin.recruitment.util.SecurityUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/7/3 22:53
 */
@Service
public class InfoServiceImpl extends ServiceImpl<InfoMapper, Info> implements IInfoService {

    @Resource
    private InfoConverter infoConverter;
    @Resource
    private EducationMapper educationMapper;
    @Resource
    private JobMapper jobMapper;
    @Resource
    private ProjectMapper projectMapper;
    @Resource
    private EducationConverter educationConverter;
    @Resource
    private JobConverter jobConverter;
    @Resource
    private ProjectConverter projectConverter;

    @Override
    public Result<String> saveInfo(InfoFrom infoFrom) {
        LambdaQueryWrapper<Info> wrapper = new LambdaQueryWrapper<Info>().eq(Info::getUserId, SecurityUtil.getUserId());
        int count = baseMapper.selectCount(wrapper).intValue();
        if (count > 0) {
            return Result.failed("个人信息已存在，暂不支持添加多个个人信息，请在原先的个人信息基础上修改");
        }
        Info info = infoConverter.fromToEntity(infoFrom);
        int inserted = baseMapper.insert(info);
        return inserted > 0 ? Result.success("个人基本信息保存成功") : Result.failed("个人基本信息保存失败");
    }

    @Override
    public Result<String> modifyInfo(InfoFrom infoFrom) {
        Info info = infoConverter.fromToEntity(infoFrom);
        int updated = baseMapper.updateById(info);
        return updated > 0 ? Result.success("个人基本信息修改成功") : Result.failed("个人基本信息修改失败");
    }

    @Override
    public Result<InfoVO> queryInfo() {
        LambdaQueryWrapper<Info> wrapper = new LambdaQueryWrapper<Info>().eq(Info::getUserId, SecurityUtil.getUserId());
        Info info = baseMapper.selectOne(wrapper);
        InfoVO infoVO = infoConverter.entityToVO(info);
        return Objects.nonNull(infoVO) ? Result.success("个人基本信息获取成功", infoVO) : Result.failed("个人基本信息获取失败");
    }

    @Override
    public Result<ResumeVO> queryResume(Integer userId) {
        //获取基本信息
        LambdaQueryWrapper<Info> infoWrapper = new LambdaQueryWrapper<Info>().eq(Info::getUserId, SecurityUtil.getUserId());
        Info info = baseMapper.selectOne(infoWrapper);

        ResumeVO resumeVO = infoConverter.entityTOResumeVO(info);

        LambdaQueryWrapper<Education> educationWrapper = new LambdaQueryWrapper<Education>()
                .eq(Education::getUserId, SecurityUtil.getUserId());
        List<Education> educations = educationMapper.selectList(educationWrapper);

        LambdaQueryWrapper<Job> jobWrapper = new LambdaQueryWrapper<Job>().eq(Job::getUserId, SecurityUtil.getUserId());
        List<Job> jobs = jobMapper.selectList(jobWrapper);

        LambdaQueryWrapper<Project> projectWrapper = new LambdaQueryWrapper<Project>()
                .eq(Project::getUserId, SecurityUtil.getUserId());
        List<Project> projects = projectMapper.selectList(projectWrapper);

        resumeVO.setEducationVOS(educationConverter.listEntityToListVO(educations));
        resumeVO.setJobVOS(jobConverter.listEntityToListVO(jobs));
        resumeVO.setProjectVOS(projectConverter.listEntityToListVO(projects));


        return Result.success(null,resumeVO);
    }

}
