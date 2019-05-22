package com.developlee.mybatispagehelper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.developlee.mybatispagehelper.dao")
public class MybatisPagehelperApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPagehelperApplication.class, args);
    }
}
