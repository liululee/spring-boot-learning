package com.developlee.springsecuritypermissions.config;

import com.developlee.springsecuritypermissions.filter.MyFilterSecurityInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author: liululee
 * @since: 2019/4/28-20:41
 * @description:
 **/
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login").loginProcessingUrl("/login").permitAll();
        http.authorizeRequests()
                .anyRequest().authenticated(); //任何请求,登录后可以访问
        http.logout().permitAll(); //注销行为任意访问
        http.addFilterBefore(new MyFilterSecurityInterceptor(), UsernamePasswordAuthenticationFilter.class);
    }
}
