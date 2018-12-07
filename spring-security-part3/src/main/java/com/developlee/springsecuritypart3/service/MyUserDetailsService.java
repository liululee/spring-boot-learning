package com.developlee.springsecuritypart3.service;

import com.developlee.springsecuritypart3.dao.UserRepository;
import com.developlee.springsecuritypart3.domain.MyUserDetails;
import com.developlee.springsecuritypart3.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author developlee
 * @since 2018/11/27 21:33
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 从数据库查询用户
        User user = userRepository.findByUsername(username);
        if(user == null) {
             throw new UsernameNotFoundException("用户" + username + "不存在");
        }
        return new MyUserDetails(user);
    }
}
