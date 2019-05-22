package com.developlee.redis.controller;

import com.developlee.redis.entity.UserEntity;
import com.developlee.redis.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lensen
 * @desc
 * @since 2018/8/27 10:42
 */
@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("user/{id}")
    public UserEntity findUserById(@PathVariable("id") Long id) {
        return userService.findUserById(id);
    }
}
