package com.developlee.springsecuritypermissions.controller;

import com.developlee.springsecuritypermissions.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liululee
 * @desc
 * @since 6/14/2019
 **/
@Controller
public class WelcomeController {



    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
