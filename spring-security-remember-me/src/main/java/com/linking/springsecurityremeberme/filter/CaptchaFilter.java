package com.linking.springsecurityremeberme.filter;

import com.linking.springsecurityremeberme.config.AppConfig;
import com.linking.springsecurityremeberme.exception.ValidateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.filter.OncePerRequestFilter;
import org.thymeleaf.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author developlee
 * @since 2019/1/14 16:42
 */
@Slf4j
public class CaptchaFilter extends OncePerRequestFilter {

    @Autowired
    private AppConfig appConfig;

    private AuthenticationFailureHandler authenticationFailureHandler;

    // 注入appConfig
    public CaptchaFilter(AppConfig appConfig, AuthenticationFailureHandler authenticationFailureHandler) {
        this.appConfig = appConfig;
        this.authenticationFailureHandler = authenticationFailureHandler;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        if (httpServletRequest.getRequestURI().equals(appConfig.getLoginUri().trim()) && httpServletRequest.getMethod().equals(RequestMethod.POST.name())) {
            try {
                validateCode(httpServletRequest);
            } catch (ValidateException e) {
                authenticationFailureHandler.onAuthenticationFailure(httpServletRequest, httpServletResponse, e);
                return;
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    /**
     * 验证码的认证
     *
     * @param userValidateCode
     * @throws ValidateException
     */
    private void validateCode(HttpServletRequest httpServletRequest) throws ValidateException {
        // 如果是登录请求，并且是post方式访问，则校验验证码
        String userValidateCode = httpServletRequest.getParameter("validateCode");
        String sysValidateCode = (String) httpServletRequest.getSession().getAttribute("imageCode");
        log.info("用户输入的验证码是：{},系统保存的验证码是：{}", userValidateCode, sysValidateCode);
        // 和我们保存的验证码进行比较
        if (StringUtils.isEmpty(userValidateCode)) {
            throw new ValidateException("验证码信息不能为空");
        }
        if (!StringUtils.equalsIgnoreCase(userValidateCode, sysValidateCode)) {
            throw new ValidateException("验证码不正确");
        }
    }
}
