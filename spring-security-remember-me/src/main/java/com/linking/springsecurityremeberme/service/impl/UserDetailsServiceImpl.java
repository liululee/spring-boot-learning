package com.linking.springsecurityremeberme.service.impl;


import com.linking.springsecurityremeberme.domain.UserEntity;
import com.linking.springsecurityremeberme.domain.vo.AuthUserDetails;
import com.linking.springsecurityremeberme.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author developlee
 * @since 2019/1/15 14:34
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity =  userRepository.findUserEntityByUsername(username);
        return new AuthUserDetails(userEntity);
    }
}
