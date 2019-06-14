package com.developlee.springsecuritypermissions.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author liululee
 * @desc login or logout
 * @since 6/14/2019
 **/
@Slf4j
@Controller
public class SignController {

    /**
     * 自定义登录页
     *
     * @return
     */
    @GetMapping("/login")
    public String login() {
        return "sign_in";
    }

    @PostMapping("/login")
    public ResponseEntity loginProcess(@RequestParam("username") String username, @RequestParam("password") String password){
        log.info("username = {} password = {}", username, password);
        return new ResponseEntity("OK", HttpStatus.OK);
    }
    /**
     * logout
     */
    @PostMapping("/logout")
    public void logout() {

    }
}
