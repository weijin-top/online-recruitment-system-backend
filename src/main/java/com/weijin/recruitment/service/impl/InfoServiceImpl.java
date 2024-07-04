package com.weijin.recruitment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.weijin.recruitment.converter.InfoConverter;
import com.weijin.recruitment.mapper.InfoMapper;
import com.weijin.recruitment.model.entity.Info;
import com.weijin.recruitment.model.from.info.InfoFrom;
import com.weijin.recruitment.model.result.Result;
import com.weijin.recruitment.model.vo.info.InfoVO;
import com.weijin.recruitment.service.IInfoService;
import com.weijin.recruitment.util.SecurityUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

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

}
