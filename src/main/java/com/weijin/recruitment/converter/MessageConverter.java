package com.weijin.recruitment.converter;

import com.weijin.recruitment.model.entity.Message;
import com.weijin.recruitment.model.from.message.MessageFrom;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2025/3/24 18:55
 */
@Component
@Mapper(componentModel = "spring")
public interface MessageConverter {
    Message fromToEntity(MessageFrom messageFrom);
}
