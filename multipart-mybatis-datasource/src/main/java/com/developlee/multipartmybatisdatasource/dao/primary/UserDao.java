package com.developlee.multipartmybatisdatasource.dao.primary;

import com.developlee.multipartmybatisdatasource.entity.primary.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * @author Lensen
 * @desc
 * @since 2018/9/19 10:40
 */
@Repository
public interface UserDao {
    int saveUser(UserEntity userEntity);
    UserEntity getUserById(Long id);
}
