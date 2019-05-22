package com.developlee.swaggerstarter.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lensen
 * @desc
 * @since 2018/8/27 13:37
 */
@RestController
public class HelloController {

    @GetMapping(value = "hello")
    public ResponseEntity sayHello() {
        return new ResponseEntity("hello", HttpStatus.OK);
    }
}
