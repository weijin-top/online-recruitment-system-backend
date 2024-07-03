package com.weijin.recruitment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.weijin.recruitment.converter.InfoConverter;
import com.weijin.recruitment.mapper.InfoMapper;
import com.weijin.recruitment.model.entity.Info;
import com.weijin.recruitment.model.from.info.InfoFrom;
import com.weijin.recruitment.model.result.Result;
import com.weijin.recruitment.service.IInfoService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

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
        Info info = infoConverter.fromToEntity(infoFrom);
        int inserted = baseMapper.insert(info);
        return inserted > 0 ? Result.success("个人基本信息保存成功") : Result.failed("个人基本信息保存失败");
    }
}
