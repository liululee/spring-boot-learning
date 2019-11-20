package com.developlee.springbootassembly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootAssemblyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAssemblyApplication.class, args);
    }

    /**
     * a test method
     * @return
     */
    @GetMapping("/assembly")
    public String assembly() {
        return "Hello, try assembly package way!";
    }
}
