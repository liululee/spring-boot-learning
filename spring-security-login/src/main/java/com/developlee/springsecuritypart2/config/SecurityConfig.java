package com.developlee.springsecuritypart2.config;

import com.developlee.springsecuritypart2.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author developlee
 * @since 2018/11/25 17:45
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 设置form 登录方式，且成功跳转至hello页面
        http.formLogin().successForwardUrl("/hello")
                // 设置所有的请求都要经过验证
                .and().authorizeRequests().anyRequest().authenticated()
                // 设置自定义的UserDetailsService
                .and().userDetailsService(userDetailsService);
    }

}
