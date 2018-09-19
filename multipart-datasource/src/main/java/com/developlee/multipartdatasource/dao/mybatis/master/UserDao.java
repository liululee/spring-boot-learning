package com.developlee.multipartdatasource.dao.mybatis.master;

import com.developlee.multipartdatasource.entity.jpa.primary.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    UserEntity findUserById(Long id);
}
