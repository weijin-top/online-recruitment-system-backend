package com.weijin.recruitment.service.impl;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weijin.recruitment.common.Constant;
import com.weijin.recruitment.converter.UserConverter;
import com.weijin.recruitment.mapper.UserMapper;
import com.weijin.recruitment.model.entity.User;
import com.weijin.recruitment.common.RoleEnum;
import com.weijin.recruitment.model.from.auth.LoginFrom;
import com.weijin.recruitment.model.from.user.RegisterFrom;
import com.weijin.recruitment.common.Result;
import com.weijin.recruitment.model.security.SecurityUserDetails;
import com.weijin.recruitment.service.IAuthService;
import com.weijin.recruitment.utils.CodeUtil;
import com.weijin.recruitment.utils.JwtUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
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
    private RedisTemplate<String, String> redisTemplate;

    @SneakyThrows(JsonProcessingException.class)
    @Override
    public Result<String> login(HttpServletRequest request, LoginFrom loginFrom) {
        // 判断验证码
        String key = "%s-code:%s".formatted(Constant.APPLICATION, request.getSession().getId());
        String rightCode = redisTemplate.opsForValue().get(key);
        if (!CodeUtil.verityCode(rightCode, loginFrom.getCode())) {
            return Result.failed("验证码错误");
        }
        // 验证码校验后redis清除验证码，避免重复使用
        redisTemplate.delete(key);
        // 根据用户名获取用户信息
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>()
                .eq(User::getUsername, loginFrom.getUsername());
        User user = userMapper.selectOne(wrapper);
        // 判读用户名是否存在
        if (Objects.isNull(user)) {
            return Result.failed("该用户不存在");
        }
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
        // 将用户信息转为字符串
        String userInfo = objectMapper.writeValueAsString(user);
        String token = jwtUtil.createJwt(userInfo, userPermissions.stream().map(String::valueOf).toList());

        // 封装用户的身份信息，为后续的身份验证和授权操作提供必要的输入
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(sysUserDetails, user.getPassword(), userPermissions);
        // 用户信息存放进上下文
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        return Result.success("登录成功", token);
    }

    @Override
    public Result<String> logout(HttpServletRequest request) {
        SecurityContextHolder.clearContext();
        return Result.success("退出成功");
    }

    @Override
    public Result<String> register(HttpServletRequest request, RegisterFrom registerFrom) {
        // 判断验证码
        String key = "%s-code:%s".formatted(Constant.APPLICATION, request.getSession().getId());
        String rightCode = redisTemplate.opsForValue().get(key);
        if (!CodeUtil.verityCode(rightCode, registerFrom.getCode())) {
            return Result.failed("验证码错误");
        }
        // 验证码校验后redis清除验证码，避免重复使用
        redisTemplate.delete(key);

        User user = userConverter.registerFromToEntity(registerFrom);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        int inserted = userMapper.insert(user);
        return inserted > 0 ? Result.success("注册成功") : Result.failed("注册失败");
    }

    @SneakyThrows(IOException.class)
    @Override
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response) {
        // 生成线性图形验证码的静态方法，参数：图片宽，图片高，验证码字符个数 干扰个数
        LineCaptcha captcha = CaptchaUtil
                .createLineCaptcha(200, 100, 4, 300);

        // 把验证码存放进redis
        // 获取验证码
        String code = captcha.getCode();
        String key = "%s-code:%s".formatted(Constant.APPLICATION, request.getSession().getId());
        redisTemplate.opsForValue().set(key, code, 5, TimeUnit.MINUTES);
        // 把图片响应到输出流
        response.setContentType("image/jpeg");
        ServletOutputStream os = response.getOutputStream();
        captcha.write(os);
        os.close();
    }

}
