package com.weijin.recruitment.filter;


import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weijin.recruitment.model.entity.User;
import com.weijin.recruitment.common.RoleEnum;
import com.weijin.recruitment.common.ResponseResult;
import com.weijin.recruitment.common.Result;
import com.weijin.recruitment.model.security.SecurityUserDetails;
import com.weijin.recruitment.utils.JwtUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/3/25 19:50
 */
@Slf4j
@Component
public class VerifyTokenFilter extends OncePerRequestFilter {

    @Resource
    private JwtUtil jwtUtil;
    @Resource
    private ResponseResult responseResult;
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // 登录、注册、校验验证码、获取验证码、websocket放行
        String uri = request.getRequestURI();
        if ((uri.contains("auth") && !uri.contains("logout")) || uri.contains("websocket") ||
                uri.contains("error") || uri.contains("ws")) {
            doFilter(request, response, filterChain);
            return;
        }
        // 获取jwt令牌
        String authorization = request.getHeader("Authorization");
        // 判断是否为空
        if (StringUtils.isBlank(authorization)) {
            responseResult.response(response, Result.failed("Authorization为空，请先登录"));
            return;
        }
        // 校验jwt是否过期
        boolean verify = jwtUtil.verifyToken(authorization);
        if (!verify) {
            responseResult.response(response, Result.failed("token已过期，请重新登录"));
            return;
        }
        // 验证token在redis中是否存在，key使用sessionId
//        if (Boolean.FALSE.equals(stringRedisTemplate.hasKey("token" + request.getSession().getId()))) {
//            responseResult.response(response, Result.failed("token无效，请重新登录"));
//            return;
//        }
        // 自动续期
        // stringRedisTemplate.expire("token" + request.getSession().getId(), 2, TimeUnit.HOURS);
        // 从jwt 获取用户信息和权限
        String userInfo = jwtUtil.getUser(authorization);
//        List<String> authList = jwtUtil.getAuthList(authorization);
        // 反序列化jwtToken获取用户信息
        User user = objectMapper.readValue(userInfo, User.class);
        // 权限转型
        List<GrantedAuthority> permissions = AuthorityUtils
                .commaSeparatedStringToAuthorityList(RoleEnum.getRole(user.getRoleId()));
        // 创建登录用户
        SecurityUserDetails securityUser = new SecurityUserDetails(user);
        securityUser.setPermissions(permissions);
        // 创建权限授权的token 参数：用户，密码，权限 不给密码因为已经登录了
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(securityUser, null, permissions);
        // 通过安全上下文设置授权token
        SecurityContextHolder.getContext().setAuthentication(token);
        // 放行
        doFilter(request, response, filterChain);
    }
}
