package com.weijin.recruitment.service.impl;

import com.weijin.recruitment.model.entity.User;
import com.weijin.recruitment.mapper.UserMapper;
import com.weijin.recruitment.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author WeiJin
 * @since 2024-06-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
