package com.weijin.recruitment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weijin.recruitment.converter.UserConverter;
import com.weijin.recruitment.mapper.CompanyMapper;
import com.weijin.recruitment.mapper.UserMapper;
import com.weijin.recruitment.model.entity.Company;
import com.weijin.recruitment.model.entity.User;
import com.weijin.recruitment.model.enumtype.RoleEnum;
import com.weijin.recruitment.model.from.auth.LoginFrom;
import com.weijin.recruitment.model.from.user.UserFrom;
import com.weijin.recruitment.model.result.Result;
import com.weijin.recruitment.model.security.SecurityUserDetails;
import com.weijin.recruitment.service.IAuthService;
import com.weijin.recruitment.util.JwtUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.SneakyThrows;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/7/2 15:33
 */
@Service
public class AuthServiceImpl implements IAuthService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private PasswordEncoder passwordEncoder;
    @Resource
    private JwtUtil jwtUtil;
    @Resource
    private ObjectMapper objectMapper;
    @Resource
    private UserConverter userConverter;
    @Resource
    private CompanyMapper companyMapper;


    @SneakyThrows(JsonProcessingException.class)
    @Override
    public Result<String> login(HttpServletRequest request, LoginFrom loginFrom) {
        // 根据用户名获取用户信息
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>()
                .eq(User::getUsername, loginFrom.getUsername());
        User user = userMapper.selectOne(wrapper);

        // 判读用户名是否存在
        if (Objects.isNull(user)) {
            return Result.failed("该用户不存在");
        }
//        if (user.getIsDeleted() == 1) {
//            return Result.failed("该用户已注销");
//        }

        if (!passwordEncoder.matches(loginFrom.getPassword(), user.getPassword())) {
            return Result.failed("密码错误");
        }
        user.setPassword(null);


        // 生成基于角色的授权访问控制
        List<GrantedAuthority> userPermissions = AuthorityUtils
                .commaSeparatedStringToAuthorityList(RoleEnum.getRole(user.getRoleId()));
        // 创建一个sysUserDetails对象，该类实现了UserDetails接口
        SecurityUserDetails sysUserDetails = new SecurityUserDetails(user);
        // 把转型后的权限放进sysUserDetails对象
        sysUserDetails.setPermissions(userPermissions);
        //如果是招聘者登录，把它的公司id保存到Security的上下文中
        if (user.getRoleId() == 2) {
            LambdaQueryWrapper<Company> companyLambdaQueryWrapper = new LambdaQueryWrapper<Company>()
                    .eq(Company::getUserId, user.getId());
            Company company = companyMapper.selectOne(companyLambdaQueryWrapper);
            sysUserDetails.setCompanyId(Objects.nonNull(company) ? company.getId() : null);
        }
        // 将用户信息转为字符串
        String userInfo = objectMapper.writeValueAsString(user);
        String token = jwtUtil.createJwt(userInfo, userPermissions.stream().map(String::valueOf).toList());
        // 把token放到redis中
//        stringRedisTemplate.opsForValue().set("token" + request.getSession().getId(), token, 30, TimeUnit.MINUTES);
        // 封装用户的身份信息，为后续的身份验证和授权操作提供必要的输入
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(sysUserDetails, user.getPassword(), userPermissions);
        // 用户信息存放进上下文
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        // 清除redis通过校验表示
//        stringRedisTemplate.delete("isVerifyCode" + request.getSession().getId());
        return Result.success("登录成功", token);
    }

    @Override
    public Result<String> logout(HttpServletRequest request) {
        SecurityContextHolder.clearContext();
        return Result.success("退出成功");
    }

    @Override
    public Result<String> register(UserFrom userFrom) {
        User user = userConverter.fromToEntity(userFrom);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        int inserted = userMapper.insert(user);
        return inserted > 0 ? Result.success("注册成功") : Result.failed("注册失败");
    }
}
