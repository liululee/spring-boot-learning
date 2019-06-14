package com.developlee.springsecuritypermissions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class SpringSecurityPermissionsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityPermissionsApplication.class, args);
    }

}
