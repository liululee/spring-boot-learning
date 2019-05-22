package com.developlee.druid.domain.jpa;

import com.developlee.druid.domain.Vo.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Lensen
 * @desc
 * @since 2018/8/26 21:37
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findUserEntityById(Long id);

}
