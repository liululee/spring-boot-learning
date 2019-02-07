package com.linking.springsecurityremeberme.repository;

import com.linking.springsecurityremeberme.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author developlee
 * @since 2019/1/15 14:26
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findUserEntityByUsername(String username);

    UserEntity findUserEntityById(Long id);
}
