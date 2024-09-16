package com.weijin.recruitment.service.impl;


import com.weijin.recruitment.converter.UserConverter;
import com.weijin.recruitment.model.entity.User;
import com.weijin.recruitment.mapper.UserMapper;
import com.weijin.recruitment.common.Result;
import com.weijin.recruitment.model.from.user.ModifyPasswordFrom;
import com.weijin.recruitment.model.from.user.UserFrom;
import com.weijin.recruitment.model.vo.user.UserVO;
import com.weijin.recruitment.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.weijin.recruitment.util.SecurityUtil;
import jakarta.annotation.Resource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author WeiJin
 * @since 2024-06-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserConverter userConverter;

    @Override
    public Result<UserVO> getInfo() {
        User user = baseMapper.selectById(SecurityUtil.getUserId());
        if (Objects.isNull(user)) {
            return Result.failed("当前用户不存在");
        }
        UserVO userVO = userConverter.entityToVO(user);
        return Result.success("获取成功", userVO);
    }

    @Override
    public Result<String> modifyUser(UserFrom userFrom) {
        User user = userConverter.FromToEntity(userFrom);
        int updated = baseMapper.updateById(user);
        return updated > 0 ? Result.success("修改成功") : Result.failed("修改失败");
    }

    @Override
    public Result<String> modifyPassword(ModifyPasswordFrom modifyPasswordFrom) {
        if (!modifyPasswordFrom.getNewPassword().equals(modifyPasswordFrom.getConfirmPassword())) {
            return Result.failed("两次密码不一致");
        }
        Integer userId = SecurityUtil.getUserId();
        User dbUser = baseMapper.selectById(userId);
        if (Objects.isNull(dbUser)) {
            return Result.failed("该用户不存在");
        }
        if (!new BCryptPasswordEncoder()
                .matches(modifyPasswordFrom.getOldPassword(), dbUser.getPassword())) {
            return Result.failed("旧密码错误");
        }
        User user = new User();
        //密码加密
        user.setPassword(new BCryptPasswordEncoder().encode(modifyPasswordFrom.getNewPassword()));
        user.setId(userId);
        int updated = baseMapper.updateById(user);

        return updated > 0 ? Result.success("修改成功，请重新登录") : Result.failed("修改失败");

    }
}
