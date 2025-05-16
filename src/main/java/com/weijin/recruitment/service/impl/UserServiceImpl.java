package com.weijin.recruitment.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.weijin.recruitment.converter.UserConverter;
import com.weijin.recruitment.exception.AppException;
import com.weijin.recruitment.mapper.CompanyMapper;
import com.weijin.recruitment.mapper.InfoMapper;
import com.weijin.recruitment.model.dto.SessionDto;
import com.weijin.recruitment.model.entity.Company;
import com.weijin.recruitment.model.entity.Info;
import com.weijin.recruitment.model.entity.User;
import com.weijin.recruitment.mapper.UserMapper;
import com.weijin.recruitment.common.Result;
import com.weijin.recruitment.model.from.user.ModifyPasswordFrom;
import com.weijin.recruitment.model.from.user.UserFrom;
import com.weijin.recruitment.model.vo.user.UserVO;
import com.weijin.recruitment.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.weijin.recruitment.utils.SecurityUtil;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
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
    @Resource
    private InfoMapper infoMapper;
    @Resource
    private CompanyMapper companyMapper;
    @Value("${recruitment.default-password}")
    private String defaultPassword;

    @Override
    public Result<UserVO> getInfo() {
        User user = baseMapper.selectById(SecurityUtil.getUserId());
        if (Objects.isNull(user)) {
            return Result.failed("当前用户不存在");
        }
        UserVO userVO = userConverter.entityToVO(user);
        // 安全考虑 以密文显示密码
        userVO.setPassword("**********");
        return Result.success("获取成功", userVO);
    }

    @Override
    public Result<String> modifyUser(UserFrom userFrom) {
        User user = userConverter.fromToEntity(userFrom);
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
        // 密码加密
        user.setPassword(new BCryptPasswordEncoder().encode(modifyPasswordFrom.getNewPassword()));
        user.setId(userId);
        int updated = baseMapper.updateById(user);

        return updated > 0 ? Result.success("修改成功，请重新登录") : Result.failed("修改失败");

    }

    @Override
    public SessionDto queryInfoByUserId(Integer userId) {
        User user = baseMapper.selectById(userId);
        if (Objects.isNull(user)) {
            throw new AppException("该用户不存在");
        }
        SessionDto sessionDto = userConverter.entityToSessionDto(user);
        // 根据角色id获取 name 1求职者 获取真实姓名 2招聘者 获取公司简称
        if (user.getRoleId() == 1) {
            LambdaQueryWrapper<Info> wrapper = new LambdaQueryWrapper<Info>().eq(Info::getUserId, userId);
            Info info = infoMapper.selectOne(wrapper);
            // 刚注册的用户还没来得及添加简历信息，所以用户信息可能为空
            if (Objects.isNull(info)) {
                return sessionDto;
            }
            // 不为空，加入用户信息
            sessionDto.setName(info.getName());
        } else if (user.getRoleId() == 2) {
            LambdaQueryWrapper<Company> wrapper = new LambdaQueryWrapper<Company>().eq(Company::getUserId, userId);
            Company company = companyMapper.selectOne(wrapper);
            if (Objects.isNull(company)) {
                return sessionDto;
            }
            // 不为空，加入用户信息
            sessionDto.setName(company.getNickname());
        }
        return sessionDto;
    }

    @Override
    public Result<IPage<UserVO>> pageUser(Integer pageNum, Integer pageSize, String username, Integer roleId) {
        IPage<User> page = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>()
                .like(StringUtils.isNotBlank(username), User::getUsername, username)
                .eq(roleId != null, User::getRoleId, roleId)
                // 不查询你管理员用户
                .ne(User::getRoleId, 3)
                .orderByDesc(User::getCreateTime);
        page = baseMapper.selectPage(page, wrapper);
        IPage<UserVO> resPage = userConverter.pageEntityToPageVO(page);
        resPage.getRecords().forEach(item -> item.setPassword("********"));
        return Result.success("查询成功", resPage);
    }

    @Override
    public Result<String> resetPassword(Integer id) {
        User user = baseMapper.selectById(id);
        if (Objects.isNull(user)) {
            return Result.failed("用户不存在");
        }
        // 密码加密
        String encodePassword = new BCryptPasswordEncoder().encode(defaultPassword);
        user.setPassword(encodePassword);
        int updated = baseMapper.updateById(user);
        if (updated > 0) {
            return Result.success("重置密码成功");
        }
        return Result.failed("重置密码失败");
    }
}
