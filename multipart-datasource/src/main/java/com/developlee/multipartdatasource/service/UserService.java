package com.developlee.multipartdatasource.service;

import com.developlee.multipartdatasource.entity.jpa.primary.UserEntity;
import com.developlee.multipartdatasource.entity.mybatis.master.MybatisUserEntity;

public interface UserService {
    void saveUserByJpa(UserEntity userEntity);
    void saveUserByMybatis(MybatisUserEntity mybatisUserEntity);
}
