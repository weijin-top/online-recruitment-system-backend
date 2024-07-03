package com.weijin.recruitment.util;


import com.weijin.recruitment.model.security.SecurityUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/3/30 0:10
 */
@Slf4j
public class SecurityUtil {

    private SecurityUtil() {
    }

    /**
     * 获取当前用户id
     *
     * @return 用户id
     */
    public static Integer getUserId() {
        SecurityUserDetails user = (SecurityUserDetails) (SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal());
        return user != null ? user.getUser().getId() : null;
    }

    /**
     * 获取当前用户角色
     *
     * @return 角色
     */
    public static String getRole() {
        List<? extends GrantedAuthority> list = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getAuthorities()
                .stream()
                .toList();

        return !list.isEmpty() ? list.get(0).toString() : null;
    }


}
