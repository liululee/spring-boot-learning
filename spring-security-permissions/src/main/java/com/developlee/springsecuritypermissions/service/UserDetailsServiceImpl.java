package com.developlee.springsecuritypermissions.service;

import com.developlee.springsecuritypermissions.domain.UserDetailsImpl;
import com.developlee.springsecuritypermissions.domain.UserEntity;
import com.developlee.springsecuritypermissions.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: liululee
 * @since: 2019/4/28-21:13
 * @description:
 **/
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username);
        if(userEntity == null) {
            throw new UsernameNotFoundException("Your Username Maybe Not True");
        }
        return new UserDetailsImpl(userEntity);
    }
}
