package com.developlee.multipartdatasource.service.impl;

import com.developlee.multipartdatasource.dao.jpa.primary.UserRepository;
import com.developlee.multipartdatasource.entity.jpa.primary.UserEntity;
import com.developlee.multipartdatasource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Lensen
 * @desc
 * @since 2018/8/23 17:31
 */
@Service
public class UserServiceImpl implements UserService {
//    @Autowired
//    private UserDao userDao;

    @Autowired
    private UserRepository userRepository;

    public UserEntity findUserByIdWithJpa(Long id) {
        return userRepository.findUserEntityById(id);
    }

}
