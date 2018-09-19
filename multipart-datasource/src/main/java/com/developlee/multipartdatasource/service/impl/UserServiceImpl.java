package com.developlee.multipartdatasource.service.impl;

import com.developlee.multipartdatasource.dao.jpa.primary.UserRepository;
import com.developlee.multipartdatasource.dao.mybatis.master.UserDao;
import com.developlee.multipartdatasource.entity.jpa.primary.UserEntity;
import com.developlee.multipartdatasource.entity.mybatis.master.MybatisUserEntity;
import com.developlee.multipartdatasource.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Lensen
 * @desc
 * @since 2018/8/23 17:31
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserDao userDao;


    @Override
    public void saveUserByJpa(UserEntity userEntity) {
        log.info("JPA-Primary数据源执行添加UserEntity操作");
        userRepository.save(userEntity);
    }

    @Override
    public void saveUserByMybatis(MybatisUserEntity mybatisUserEntity) {
        log.info("Mybatis-Master数据源执行添加MybatisUserEntity操作");
        userDao.save(mybatisUserEntity);

    }
}
