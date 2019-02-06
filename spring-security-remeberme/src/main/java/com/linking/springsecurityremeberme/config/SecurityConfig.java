package com.linking.springsecurityremeberme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.RememberMeAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;
import service.UserDetailsServiceImpl;

/**
 * @author developlee
 * @since 2019/1/18 15:30
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(rememberMeAuthenticationProvider());
    }

    public RememberMeAuthenticationProvider rememberMeAuthenticationProvider() {
        RememberMeAuthenticationProvider provider = new RememberMeAuthenticationProvider("springRocks");
        return provider;
    }

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    public TokenBasedRememberMeServices tokenBasedRememberMeServices() {
        TokenBasedRememberMeServices tokenBasedRememberMeServices = new TokenBasedRememberMeServices(userDetailsService);
        tokenBasedRememberMeServices.setTokenValiditySeconds(30*24*60*60); // 设置token过期时间30天
        tokenBasedRememberMeServices.setAlwaysRemember(true); // 登录成功刷新token过期时间
        tokenBasedRememberMeServices.setCookieName("REMEBER_ME_COOKIES");// 设置cookies过期时间

        return tokenBasedRememberMeServices;
    }
}
