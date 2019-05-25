package com.developlee.elklog4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ElkLog4jApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElkLog4jApplication.class, args);
    }
}
