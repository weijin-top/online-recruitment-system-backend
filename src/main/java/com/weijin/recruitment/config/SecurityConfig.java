package com.weijin.recruitment.config;

import com.weijin.recruitment.filter.VerifyTokenFilter;
import com.weijin.recruitment.common.ResponseResult;
import com.weijin.recruitment.common.Result;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/7/2 14:55
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Resource
    private ResponseResult responseResult;
    @Resource
    private VerifyTokenFilter verifyTokenFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.formLogin(AbstractHttpConfigurer::disable);

        http.authorizeHttpRequests(auth -> {
            auth.requestMatchers("/api/auth/**").permitAll();
            auth.requestMatchers("/websocket").permitAll();
            auth.requestMatchers("/api/auth/logout").authenticated();
            auth.anyRequest().authenticated();
        });
        // 配置拒绝访问处理器
        http.exceptionHandling(exceptionHandling -> exceptionHandling
                .accessDeniedHandler((request, response, accessDeniedException)
                        -> responseResult.response(response, Result.failed(401, "你没有该资源的访问权限"))));
        // 自定义登录验证过滤器
        http.addFilterBefore(verifyTokenFilter, UsernamePasswordAuthenticationFilter.class);
        // 禁用 CSRF
        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }
}
