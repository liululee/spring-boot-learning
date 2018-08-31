package com.developlee.mybatispagehelper.controller;

import com.developlee.mybatispagehelper.domain.PageEntity;
import com.developlee.mybatispagehelper.domain.UserEntity;
import com.developlee.mybatispagehelper.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/userList")
    public ResponseEntity userList (){
        UserEntity userEntity = new UserEntity();
        List<UserEntity> userEntityList = userService.findUserListByPage(userEntity);
        //Log.info(userEntityList);
        return new ResponseEntity(userEntityList, HttpStatus.OK);
    }
    @PostMapping("/queryList")
    public ResponseEntity queryList(@RequestBody UserEntity userEntity) {
        List<UserEntity> userEntities = userService.findUserListByPage(userEntity);
        return new ResponseEntity( new PageEntity<>(userEntities), HttpStatus.OK);
    }

}
