//package com.developlee.springsecuritypart1.com.linking.springsecurityremeberme.service;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
///**
// * @author developlee
// * @since 2018/11/18 19:09
// */
//@Slf4j
//@Component
//public class MyUserDetailsService implements UserDetailsService {
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        // 从数据库中查找用户名密码
//
//        return new User(username, "123456", AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
//    }
//}
