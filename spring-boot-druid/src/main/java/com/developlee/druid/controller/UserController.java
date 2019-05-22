package com.developlee.druid.controller;

import com.developlee.druid.domain.Vo.UserEntity;
import com.developlee.druid.domain.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lensen
 * @desc
 * @since 2018/8/26 21:39
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/{id}")
    public UserEntity find(@PathVariable("id") Long id) {
        return userRepository.findUserEntityById(id);
    }
}
