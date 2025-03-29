package com.weijin.recruitment.converter;

import com.weijin.recruitment.model.dto.SessionDto;
import com.weijin.recruitment.model.entity.User;
import com.weijin.recruitment.model.from.user.RegisterFrom;
import com.weijin.recruitment.model.from.user.UserFrom;
import com.weijin.recruitment.model.vo.user.UserVO;
import com.weijin.recruitment.model.websocket.SocketSession;
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

    User registerFromToEntity(RegisterFrom registerFrom);

    UserVO entityToVO(User user);

    User FromToEntity(UserFrom userFrom);

    SessionDto entityToSessionDto(User user);

    SocketSession dtoToSocketSession(SessionDto sessionDto);

}
