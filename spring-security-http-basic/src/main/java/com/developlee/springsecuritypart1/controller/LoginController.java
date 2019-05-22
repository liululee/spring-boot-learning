package com.developlee.springsecuritypart1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author developlee
 * @since 2018/11/17 22:02
 */
@RestController
public class LoginController {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
