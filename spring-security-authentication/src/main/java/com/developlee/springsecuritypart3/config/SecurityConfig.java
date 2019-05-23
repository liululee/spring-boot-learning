package com.developlee.springsecuritypart3.config;

import com.developlee.springsecuritypart3.handler.MyLoginHandler;
import com.developlee.springsecuritypart3.handler.MyLogoutHandler;
import com.developlee.springsecuritypart3.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * @author developlee
 * @since 2018/11/27 21:58
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final MyLoginHandler myLoginHandler;

    private final MyLogoutHandler myLogoutHandler;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    public SecurityConfig(MyLoginHandler myLoginHandler, MyLogoutHandler myLogoutHandler) {
        this.myLoginHandler = myLoginHandler;
        this.myLogoutHandler = myLogoutHandler;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 自定义用户登录页，并允许客户端请求
        http.formLogin().loginPage("/login").permitAll()
                .loginProcessingUrl("/sign_in")
                // 配置登录成功的handler
                .successHandler(myLoginHandler)
                .and().authorizeRequests().anyRequest().authenticated();
        // 配置登出的handler
        http.logout().logoutUrl("/sign_out")
                .addLogoutHandler(myLogoutHandler)
                // logout 成功，删除 cookies
                .deleteCookies("web-site", "custom-token").clearAuthentication(true)
        // Spring Security 默认是开启了CSRF 保护的，所以logout操作必须是用POST方式请求，
        // 如果非要使用GET请求来logout的话，也可以在代码中的实现
        .logoutRequestMatcher(new AntPathRequestMatcher("/sign_out","GET"));
        //session管理   session失效后跳转
        http.sessionManagement().invalidSessionUrl("/login");
        //只允许一个用户登录,如果同一个账户两次登录,那么第一个账户将被踢下线,跳转到登录页面
        http.sessionManagement().maximumSessions(1).expiredUrl("/login");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder());
        auth.eraseCredentials(false);
    }
}
