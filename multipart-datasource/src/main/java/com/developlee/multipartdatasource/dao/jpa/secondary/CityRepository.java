package com.developlee.multipartdatasource.dao.jpa.secondary;

import com.developlee.multipartdatasource.entity.jpa.primary.UserEntity;
import com.developlee.multipartdatasource.entity.jpa.secondary.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Lensen
 * @desc
 * @since 2018/8/27 16:07
 */
public interface CityRepository  extends JpaRepository<CityEntity, Long> {
    @Override
    <S extends CityEntity> S save(S s);

}
