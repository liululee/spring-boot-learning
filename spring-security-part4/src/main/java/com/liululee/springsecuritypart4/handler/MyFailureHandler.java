package com.liululee.springsecuritypart4.handler;

import com.liululee.springsecuritypart4.exception.ValidateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;

/**
 * 登录失败处理逻辑
 */
@Slf4j
public class MyFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        if (e instanceof ValidateException) {
            log.info("用户输入验证码错误，返回错误信息" + e.getMessage());
        }
        httpServletResponse.setHeader("content-type", "application/json");
        httpServletResponse.setCharacterEncoding("UTF-8");
        Writer writer = httpServletResponse.getWriter();
        writer.write(e.getMessage());
    }
}
