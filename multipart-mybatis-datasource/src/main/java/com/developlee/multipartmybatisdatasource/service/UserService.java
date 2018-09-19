package com.developlee.multipartmybatisdatasource.service;

import com.developlee.multipartmybatisdatasource.entity.primary.UserEntity;

public interface UserService {
    int saveUser(UserEntity userEntity);
    UserEntity getUserById(Long id);
}
