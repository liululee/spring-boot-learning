package com.linking.springsecurityremeberme.config;

import com.linking.springsecurityremeberme.filter.CaptchaFilter;
import com.linking.springsecurityremeberme.handler.MyFailureHandler;
import com.linking.springsecurityremeberme.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * @author developlee
 * @since 2019/1/18 15:30
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private DataSource dataSource;

    @Bean
    public PersistentTokenRepository tokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        // 第一次启动时，设置为true,会自动建表
        jdbcTokenRepository.setCreateTableOnStartup(false);
        return jdbcTokenRepository;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private AppConfig appConfig;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/sign_in").loginProcessingUrl(appConfig.getLoginUri())
                .defaultSuccessUrl("/welcome").permitAll()
                .failureHandler(new MyFailureHandler())
                .and().authorizeRequests().antMatchers("/code/image").permitAll()
                .and().addFilterBefore(new CaptchaFilter(appConfig, new MyFailureHandler()), UsernamePasswordAuthenticationFilter.class)
                .logout().logoutUrl("/auth/logout").clearAuthentication(true)
                .and().rememberMe().tokenRepository(tokenRepository())
                .alwaysRemember(true)
                .tokenValiditySeconds(300)
                .userDetailsService(userDetailsService)
                .and().authorizeRequests().anyRequest().authenticated();
    }

}
