package com.developlee.springsecuritypart2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author developlee
 * @since 2018/11/25 20:40
 */
@RestController
public class HelloController {
    @PostMapping("/hello")
    public String hello(){
        return "Hello ! My Dear Friend !";
    }
}
