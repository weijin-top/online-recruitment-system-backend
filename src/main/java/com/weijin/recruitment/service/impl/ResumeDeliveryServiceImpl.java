package com.weijin.recruitment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.weijin.recruitment.mapper.PositionMapper;
import com.weijin.recruitment.model.entity.Position;
import com.weijin.recruitment.model.entity.ResumeDelivery;
import com.weijin.recruitment.mapper.ResumeDeliveryMapper;
import com.weijin.recruitment.model.result.Result;
import com.weijin.recruitment.service.IResumeDeliveryService;
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
public class ResumeDeliveryServiceImpl extends ServiceImpl<ResumeDeliveryMapper, ResumeDelivery> implements IResumeDeliveryService {

    @Resource
    private ResumeDeliveryMapper resumeDeliveryMapper;
    @Resource
    private PositionMapper positionMapper;

    @Override
    public Result<String> saveResumeDelivery(Integer positionId) {

        Position position = positionMapper.selectById(positionId);
        if (Objects.isNull(position) || position.getStatus() != 1) {
            return Result.failed("投递失败，该职位已下架");
        }
        LambdaQueryWrapper<ResumeDelivery> wrapper = new LambdaQueryWrapper<ResumeDelivery>()
                .eq(ResumeDelivery::getPositionId, positionId)
                .eq(ResumeDelivery::getUserId, SecurityUtil.getUserId());
        ResumeDelivery dbResumeDelivery = resumeDeliveryMapper.selectOne(wrapper);

        if (Objects.nonNull(dbResumeDelivery)) {
            return Result.failed("投递失败，不可重复投递");
        }

        ResumeDelivery resumeDelivery = new ResumeDelivery();
        resumeDelivery.setPositionId(positionId);
        resumeDelivery.setUserId(SecurityUtil.getUserId());

        int inserted = resumeDeliveryMapper.insert(resumeDelivery);
        return inserted > 0 ? Result.success("投递成功") : Result.failed("投递失败");
    }

    @Override
    public Result<String> modifyStatus(Integer id, Integer status) {
        if (status <= 0 || status > 3) {
            return Result.failed("状态只能是1-3");
        }
        ResumeDelivery resumeDelivery = new ResumeDelivery();
        resumeDelivery.setId(id);
        resumeDelivery.setStatus(status);

        int updated = resumeDeliveryMapper.updateById(resumeDelivery);
        return updated > 0 ? Result.success("操作成功") : Result.failed("操作失败");
    }
}
