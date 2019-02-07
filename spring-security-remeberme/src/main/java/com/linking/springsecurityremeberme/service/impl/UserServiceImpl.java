package com.liululee.springsecuritypart4.service.impl;

import com.liululee.springsecuritypart4.domain.UserEntity;
import com.liululee.springsecuritypart4.repository.UserRepository;
import com.liululee.springsecuritypart4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author developlee
 * @since 2019/1/15 14:25
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity getUserEntity(Long id) {
      return userRepository.findUserEntityById(id);
    }
}
