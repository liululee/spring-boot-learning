package com.linking.springsecurityremeberme.controller;

import com.linking.springsecurityremeberme.service.impl.UserDetailsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author developlee
 * @since 2019/1/15 14:22
 */
@Slf4j
@Controller
public class AuthController {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    /**
     * 登录页面的地址
     *
     * @return
     */
    @GetMapping("/sign_in")
    public String signIn() {
        return "sign_in";
    }

    @GetMapping("/welcome")
    public String index() {
        return "welcome";
    }

    @GetMapping("/403")
    public String forbidden() {
        return "403";
    }
}
