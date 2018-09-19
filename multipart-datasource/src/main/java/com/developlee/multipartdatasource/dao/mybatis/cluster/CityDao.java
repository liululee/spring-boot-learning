package com.developlee.multipartdatasource.dao.mybatis.cluster;

import com.developlee.multipartdatasource.entity.jpa.secondary.CityEntity;

public interface CityDao {
    CityEntity findCityByUserId(Long userId);
}
