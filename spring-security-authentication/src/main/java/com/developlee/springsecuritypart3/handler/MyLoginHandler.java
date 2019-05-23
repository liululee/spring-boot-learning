package com.developlee.springsecuritypart3.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author developlee
 * @since 2018/11/27 22:01
 */
@Slf4j
@Component
public class MyLoginHandler implements AuthenticationSuccessHandler {

    // 登录成功处理
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        log.info("登录成功！");
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath().concat("/hello"));
    }
}
