package com.developlee.springsecuritypart3.dao;

import com.developlee.springsecuritypart3.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author developlee
 * @since 2018/11/27 21:43
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
