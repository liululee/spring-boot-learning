package com.developlee.springsecuritypermissions.repository;

import com.developlee.springsecuritypermissions.domain.po.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: liululee
 * @since: 2019/4/28-21:15
 * @description:
 **/
@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    UserEntity findByUsername(String username);
}
