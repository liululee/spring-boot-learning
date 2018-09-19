package com.developlee.multipartdatasource.dao.jpa.primary;

import com.developlee.multipartdatasource.entity.jpa.primary.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Override
    <S extends UserEntity> S save(S s);
    UserEntity findUserEntityById(Long id);
}
