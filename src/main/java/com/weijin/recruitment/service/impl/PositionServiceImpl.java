package com.weijin.recruitment.service.impl;

import com.weijin.recruitment.converter.PositionConverter;
import com.weijin.recruitment.model.entity.Position;
import com.weijin.recruitment.mapper.PositionMapper;
import com.weijin.recruitment.model.from.position.PositionFrom;
import com.weijin.recruitment.model.result.Result;
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

    @Override
    public Result<String> savePosition(PositionFrom positionFrom) {
        Integer companyId = SecurityUtil.getCompanyId();
        if (Objects.isNull(companyId)) {
            return Result.failed("你还没有认证公司，请先认证公司后再发布岗位");
        }
        Position position = positionConverter.fromToEntity(positionFrom);
        position.setCompanyId(companyId);
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


}
