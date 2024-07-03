package com.weijin.recruitment.converter;

import com.weijin.recruitment.model.entity.Info;
import com.weijin.recruitment.model.from.info.InfoFrom;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/7/3 23:16
 */
@Component
@Mapper(componentModel = "spring")
public interface InfoConverter {

    Info fromToEntity(InfoFrom infoFrom);
}
