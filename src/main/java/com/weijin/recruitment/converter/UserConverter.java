package com.weijin.recruitment.converter;

import com.weijin.recruitment.model.entity.User;
import com.weijin.recruitment.model.from.user.UserFrom;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/7/3 15:41
 */
@Component
@Mapper(componentModel = "spring")
public interface UserConverter {

    User fromToEntity(UserFrom userFrom);
}
