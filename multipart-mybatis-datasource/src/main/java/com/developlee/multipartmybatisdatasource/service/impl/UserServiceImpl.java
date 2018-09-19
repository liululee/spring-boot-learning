package com.developlee.multipartmybatisdatasource.service.impl;

import com.developlee.multipartmybatisdatasource.dao.primary.UserDao;
import com.developlee.multipartmybatisdatasource.entity.primary.UserEntity;
import com.developlee.multipartmybatisdatasource.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Lensen
 * @desc
 * @since 2018/9/19 11:17
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public int saveUser(UserEntity userEntity){
        log.info("主数据库对User Save");
        return userDao.saveUser(userEntity);
    }

    @Override
    public UserEntity getUserById(Long id) {
        log.info("主数据库对User Get");
        return userDao.getUserById(id);
    }
}
