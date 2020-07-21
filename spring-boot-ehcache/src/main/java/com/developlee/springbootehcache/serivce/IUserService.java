package com.developlee.springbootehcache.serivce;

import com.developlee.springbootehcache.domain.UserEntity;
import org.apache.catalina.User;

/**
 * @author: liululi
 * @date: 2020/7/21
 * @desc:
 */
public interface IUserService {

    boolean addUser(UserEntity user);

    boolean updateUser(UserEntity user);

    boolean deleteUser(Long id);

    UserEntity selectUser(Long id);
}
