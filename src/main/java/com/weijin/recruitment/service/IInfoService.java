package com.weijin.recruitment.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.weijin.recruitment.model.entity.Info;
import com.weijin.recruitment.model.from.info.InfoFrom;
import com.weijin.recruitment.model.result.Result;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/7/3 22:52
 */
public interface IInfoService extends IService<Info> {

    /**
     * 添加基本信息
     *
     * @param infoFrom 入参
     * @return 响应
     */
    Result<String> saveInfo(InfoFrom infoFrom);
}
