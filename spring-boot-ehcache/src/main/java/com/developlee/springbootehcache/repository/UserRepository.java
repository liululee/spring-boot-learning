package com.developlee.springbootehcache.repository;

import com.developlee.springbootehcache.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: liululi
 * @date: 2020/7/21
 * @desc:
 */
@Repository
public interface UserRepository  extends JpaRepository<UserEntity, Long> {
}
