package com.liululee.springsecuritypart4.config;

import com.liululee.springsecuritypart4.filter.CaptchaFilter;
import com.liululee.springsecuritypart4.handler.MyFailureHandler;
import com.liululee.springsecuritypart4.service.impl.UserDetailsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author developlee
 * @since 2019/1/15 14:14
 */
@Slf4j
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

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
                .and().authorizeRequests().anyRequest().authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }


}
