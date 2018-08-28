package com.developlee.redis.service;

import com.developlee.redis.entity.UserEntity;

public interface UserService {
    UserEntity findUserById (Long id);
}
