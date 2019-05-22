package com.developlee.redis.service.impl;

import com.developlee.redis.dao.UserRepository;
import com.developlee.redis.entity.UserEntity;
import com.developlee.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author Lensen
 * @desc
 * @since 2018/8/27 10:29
 */
@Service
@CacheConfig(cacheNames = "userCache") //该类下的缓存数据 都放到userCache缓存块中
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Cacheable(keyGenerator = "myKeyGenerator", unless = "#result eq null")
    public UserEntity findUserById(Long id) {
        return userRepository.findUserEntityById(id);
    }
}
