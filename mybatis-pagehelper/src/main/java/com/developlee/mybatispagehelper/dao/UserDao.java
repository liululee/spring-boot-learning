package com.developlee.mybatispagehelper.dao;

import com.developlee.mybatispagehelper.domain.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    List<UserEntity> getUserListWithPage(UserEntity userEntity);
}
