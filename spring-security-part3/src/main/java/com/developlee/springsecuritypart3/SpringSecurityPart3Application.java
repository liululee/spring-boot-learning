package com.developlee.springsecuritypart3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class SpringSecurityPart3Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityPart3Application.class, args);
    }
}
