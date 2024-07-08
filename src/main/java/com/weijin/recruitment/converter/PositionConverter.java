package com.weijin.recruitment.converter;

import com.weijin.recruitment.model.entity.Position;
import com.weijin.recruitment.model.from.position.PositionFrom;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/7/8 21:23
 */
@Component
@Mapper(componentModel = "spring")
public interface PositionConverter {
    Position fromToEntity(PositionFrom positionFrom);
}
