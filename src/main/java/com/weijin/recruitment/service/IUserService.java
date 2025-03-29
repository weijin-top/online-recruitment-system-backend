package com.weijin.recruitment.service;

import com.weijin.recruitment.model.dto.SessionDto;
import com.weijin.recruitment.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.weijin.recruitment.common.Result;
import com.weijin.recruitment.model.from.user.ModifyPasswordFrom;
import com.weijin.recruitment.model.from.user.UserFrom;
import com.weijin.recruitment.model.vo.user.UserVO;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author WeiJin
 * @since 2024-06-30
 */
public interface IUserService extends IService<User> {

    /**
     * 获取当前登录用户信息
     *
     * @return 响应
     */
    Result<UserVO> getInfo();

    /**
     * 修改用户信息
     *
     * @param userFrom 用户信息
     * @return 用户名
     */
    Result<String> modifyUser(UserFrom userFrom);

    /**
     * 修改密码
     *
     * @param modifyPasswordFrom 入参
     * @return 响应
     */
    Result<String> modifyPassword(ModifyPasswordFrom modifyPasswordFrom);

    /**
     * 根据用户id获取信息，并返回SessionDto类型
     *
     * @param userId 用户id
     * @return sessionDto
     */
    SessionDto queryInfoByUserId(Integer userId);
}
