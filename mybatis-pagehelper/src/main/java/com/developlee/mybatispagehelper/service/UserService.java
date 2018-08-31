package com.developlee.mybatispagehelper.service;

import com.developlee.mybatispagehelper.domain.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> findUserListByPage(UserEntity userEntity);
}
