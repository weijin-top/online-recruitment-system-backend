package com.weijin.recruitment.converter;

import com.weijin.recruitment.model.entity.Post;
import com.weijin.recruitment.model.from.post.PostFrom;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/7/2 17:56
 */
@Component
@Mapper(componentModel="spring")
public interface PostConverter {

    Post fromToEntity(PostFrom postFrom);
}
