package com.developlee.mybatispagehelper.service.impl;

import com.developlee.mybatispagehelper.dao.UserDao;
import com.developlee.mybatispagehelper.domain.UserEntity;
import com.developlee.mybatispagehelper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<UserEntity> findUserListByPage(UserEntity userEntity) {
        return userDao.getUserListWithPage(userEntity);
    }
}
