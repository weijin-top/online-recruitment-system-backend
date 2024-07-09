package com.weijin.recruitment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.weijin.recruitment.converter.PositionConverter;
import com.weijin.recruitment.mapper.CompanyMapper;
import com.weijin.recruitment.mapper.EducationMapper;
import com.weijin.recruitment.mapper.InfoMapper;
import com.weijin.recruitment.model.entity.Company;
import com.weijin.recruitment.model.entity.Education;
import com.weijin.recruitment.model.entity.Info;
import com.weijin.recruitment.model.entity.Position;
import com.weijin.recruitment.mapper.PositionMapper;
import com.weijin.recruitment.model.from.position.PositionFrom;
import com.weijin.recruitment.model.result.Result;
import com.weijin.recruitment.model.vo.position.PositionDetailVO;
import com.weijin.recruitment.model.vo.position.PositionSimpleVO;
import com.weijin.recruitment.service.IPositionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.weijin.recruitment.util.SecurityUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author WeiJin
 * @since 2024-06-30
 */
@Service
public class PositionServiceImpl extends ServiceImpl<PositionMapper, Position> implements IPositionService {

    @Resource
    private PositionConverter positionConverter;
    @Resource
    private CompanyMapper companyMapper;
    @Resource
    private InfoMapper infoMapper;
    @Resource
    private EducationMapper educationMapper;

    @Override
    public Result<String> savePosition(PositionFrom positionFrom) {
        LambdaQueryWrapper<Company> companyLambdaQueryWrapper = new LambdaQueryWrapper<Company>()
                .eq(Company::getUserId, SecurityUtil.getUserId());
        Company company = companyMapper.selectOne(companyLambdaQueryWrapper);
        if (Objects.isNull(company)) {
            return Result.failed("你还没有认证公司，请先认证公司后再发布岗位");
        }
        if (positionFrom.getMaxSalary() < positionFrom.getMiniSalary()) {
            return Result.failed("最高薪资小于最低新增，请重新输入");
        }
        Position position = positionConverter.fromToEntity(positionFrom);
        position.setCompanyId(company.getId());
        int inserted = baseMapper.insert(position);
        return inserted > 0 ? Result.success("职位发布成功，等待管理员审核") : Result.failed("职位发布失败");
    }

    @Override
    public Result<String> modifyPosition(PositionFrom positionFrom) {
        Position position = positionConverter.fromToEntity(positionFrom);
        position.setStatus(0);
        int updated = baseMapper.updateById(position);
        return updated > 0 ? Result.success("职位修改成功，等待管理员审核") : Result.failed("职位修改失败");
    }

    @Override
    public Result<String> auditPosition(Integer id, Integer status) {
        Position position = new Position();
        position.setId(id);
        position.setStatus(status);
        int updated = baseMapper.updateById(position);
        return updated > 0 ? Result.success("操作成功") : Result.failed("操作失败");
    }

    @Override
    public Result<String> cancelPosition(Integer id) {
        Position position = new Position();
        position.setId(id);
        position.setStatus(3);
        int updated = baseMapper.updateById(position);
        return updated > 0 ? Result.success("操作成功") : Result.failed("操作失败");
    }

    @Override
    public Result<PositionDetailVO> querySinge(Integer id) {
        PositionDetailVO positionDetailVO = baseMapper.selectPositionDetailById(id);
        if (Objects.isNull(positionDetailVO)) {
            return Result.failed("岗位不存在，或岗位已被删除");
        }
        if (positionDetailVO.getStatus() == 3) {
            return Result.success("该岗位已下架", positionDetailVO);
        }
        return Result.success(null, positionDetailVO);
    }

    @Override
    public Result<IPage<PositionSimpleVO>> pagePosition(Integer pageNum, Integer pageSize, Integer edu, String address, Integer type, String name) {

//        LambdaQueryWrapper<Info> infoWrapper = new LambdaQueryWrapper<Info>().eq(Info::getUserId, SecurityUtil.getUserId());
//        Info info = infoMapper.selectOne(infoWrapper);


        IPage<PositionSimpleVO> page = new Page<>(pageNum, pageSize);

        IPage<PositionSimpleVO> positionPage = baseMapper.pagePosition(page, edu, address, type, name);


        //构建参数，如果用户没有筛选条件，就从从用户求职期望获取推荐职位

//        if (Objects.isNull(edu)) {
//            LambdaQueryWrapper<Education> eduWrapper = new LambdaQueryWrapper<Education>().eq(Education::getUserId, SecurityUtil.getUserId());
//            List<Education> educations = educationMapper.selectList(eduWrapper);
//            Integer[] levels = educations.stream().map(Education::getLevel).toArray(Integer[]::new);
//            Arrays.sort(levels);
//            edu = levels[0];
//        }
//        if (Objects.isNull(address)) {
//            address = info.getAddress();
//        }
//        if (Objects.isNull(type)) {
//            type = info.getPostId();
//        }

        return !positionPage.getRecords().isEmpty() ? Result.success("筛选成功", positionPage) : Result.failed("筛选结果为空");
    }


}
