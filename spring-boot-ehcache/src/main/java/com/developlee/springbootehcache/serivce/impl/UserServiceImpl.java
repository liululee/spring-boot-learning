package com.developlee.springbootehcache.serivce.impl;

import com.developlee.springbootehcache.domain.UserEntity;
import com.developlee.springbootehcache.repository.UserRepository;
import com.developlee.springbootehcache.serivce.IUserService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: liululi
 * @date: 2020/7/21
 * @desc:
 */
@Service
public class UserServiceImpl implements IUserService {


    @Resource
    private UserRepository userRepository;

    @Override
    @Cacheable(value = "userCache", key = "#user.id")
    public boolean addUser(UserEntity user) {
        return userRepository.saveAndFlush(user).getId() != null;
    }

    @Override
    @CachePut(value = "userCache", key = "#user.id")
    public boolean updateUser(UserEntity user) {
        return userRepository.saveAndFlush(user).getId() != null;
    }

    @Override
    @CacheEvict(value = "userCache", key = "#id")
    public boolean deleteUser(Long id) {
        return false;
    }

    @Override
    @Cacheable(value = "userCache", key = "#id")
    public UserEntity selectUser(Long id) {
        return null;
    }
}
