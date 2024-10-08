package com.weijin.recruitment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.weijin.recruitment.converter.PositionConverter;
import com.weijin.recruitment.mapper.CompanyMapper;
import com.weijin.recruitment.model.entity.Company;
import com.weijin.recruitment.model.entity.Position;
import com.weijin.recruitment.mapper.PositionMapper;
import com.weijin.recruitment.common.RoleEnum;
import com.weijin.recruitment.model.from.position.PositionFrom;
import com.weijin.recruitment.common.Result;
import com.weijin.recruitment.model.vo.position.PositionDetailVO;
import com.weijin.recruitment.model.vo.position.PositionSimpleVO;
import com.weijin.recruitment.model.vo.position.PositionVO;
import com.weijin.recruitment.service.IPositionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.weijin.recruitment.util.SecurityUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

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


    @Override
    public Result<String> savePosition(PositionFrom positionFrom) {
        LambdaQueryWrapper<Company> companyLambdaQueryWrapper = new LambdaQueryWrapper<Company>()
                .eq(Company::getUserId, SecurityUtil.getUserId());
        Company company = companyMapper.selectOne(companyLambdaQueryWrapper);
        if (Objects.isNull(company)) {
            return Result.failed("你还没有认证公司，请先认证公司后再发布岗位");
        }
//        if (company.getStatus() != 1) {
//            return Result.failed("你的公司还没通过审核或审核未通过，暂时无法发布职位");
//        }
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
        PositionDetailVO positionDetailVO = baseMapper.selectPositionDetailById(id,SecurityUtil.getUserId());
        if (Objects.isNull(positionDetailVO)) {
            return Result.failed("岗位不存在，或岗位已被删除");
        }
        if (positionDetailVO.getStatus() == 3) {
            return Result.success("该岗位已下架", positionDetailVO);
        }
        return Result.success(null, positionDetailVO);
    }

    @Override
    public Result<IPage<PositionSimpleVO>> pagePosition(Integer pageNum, Integer pageSize, Integer edu,
                                                        String address, Integer type, String name, Integer status) {

//        LambdaQueryWrapper<Info> infoWrapper = new LambdaQueryWrapper<Info>().eq(Info::getUserId, SecurityUtil.getUserId());
//        Info info = infoMapper.selectOne(infoWrapper);


        IPage<PositionSimpleVO> page = new Page<>(pageNum, pageSize);
        IPage<PositionSimpleVO> positionPage = null;
        //构建企业员工公司id参数
        Integer companyId = null;
        if(Objects.equals(SecurityUtil.getRole(), RoleEnum.getRole(2))){
            LambdaQueryWrapper<Company> wrapper = new LambdaQueryWrapper<Company>()
                    .eq(Company::getUserId, SecurityUtil.getUserId());
            Company company = companyMapper.selectOne(wrapper);
            if (Objects.isNull(company)){
                return Result.failed("你还没有认证企业，暂无数据");
            }
            companyId = company.getId();
        }
        //查询
        positionPage = baseMapper.pagePosition(page, edu, address, type, name,status,companyId);

        return Result.success("筛选成功", positionPage);
    }

    @Override
    public Result<PositionVO> queryPositionById(Integer id) {
        Position position = baseMapper.selectById(id);
        if (Objects.isNull(position)){
            return Result.failed("该职位不存在");
        }
        PositionVO positionVO = positionConverter.entityToVO(position);
        return Result.success("查询成功",positionVO);
    }


}
