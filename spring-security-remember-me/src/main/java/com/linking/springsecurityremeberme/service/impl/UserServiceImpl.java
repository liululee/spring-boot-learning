package com.linking.springsecurityremeberme.service.impl;

import com.linking.springsecurityremeberme.domain.UserEntity;
import com.linking.springsecurityremeberme.repository.UserRepository;
import com.linking.springsecurityremeberme.service.UserService;
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
