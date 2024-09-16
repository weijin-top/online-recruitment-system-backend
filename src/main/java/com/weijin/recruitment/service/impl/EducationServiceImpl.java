package com.weijin.recruitment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.weijin.recruitment.converter.EducationConverter;
import com.weijin.recruitment.model.entity.Education;
import com.weijin.recruitment.mapper.EducationMapper;
import com.weijin.recruitment.model.from.education.EducationFrom;
import com.weijin.recruitment.common.Result;
import com.weijin.recruitment.model.vo.education.EducationVO;
import com.weijin.recruitment.service.IEducationService;
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
public class EducationServiceImpl extends ServiceImpl<EducationMapper, Education> implements IEducationService {

    @Resource
    private EducationConverter educationConverter;

    @Override
    public Result<String> saveEducation(EducationFrom educationFrom) {
        Education education = educationConverter.fromToEntity(educationFrom);
        int inserted = baseMapper.insert(education);
        return inserted > 0 ? Result.success("教育经历信息保存成功") : Result.failed("教育经历信息保存失败");
    }

    @Override
    public Result<String> modifyEducation(EducationFrom educationFrom) {
        Education education = educationConverter.fromToEntity(educationFrom);
        int updated = baseMapper.updateById(education);
        return updated > 0 ? Result.success("教育经历信息修改成功") : Result.failed("教育经历信息修改失败");
    }

    @Override
    public Result<String> removeEducation(Integer id) {
        int deleted = baseMapper.deleteById(id);
        return deleted > 0 ? Result.success("教育经历信息删除成功") : Result.failed("教育经历信息删除失败");
    }

    @Override
    public Result<List<EducationVO>> queryEducation() {
        LambdaQueryWrapper<Education> wrapper = new LambdaQueryWrapper<Education>()
                .eq(Education::getUserId, SecurityUtil.getUserId());
        List<Education> educations = baseMapper.selectList(wrapper);
        List<EducationVO> educationVOS = educationConverter.listEntityToListVO(educations);
        return !educationVOS.isEmpty() ? Result.success("教育经历获取成功", educationVOS) : Result.failed("暂无教育经历信息");
    }
}
