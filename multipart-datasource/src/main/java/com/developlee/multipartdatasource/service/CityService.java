package com.developlee.multipartdatasource.service;

import com.developlee.multipartdatasource.entity.jpa.secondary.CityEntity;
import com.developlee.multipartdatasource.entity.mybatis.cluster.MybatisCityEntity;

/**
 * @author Lensen
 * @desc
 * @since 2018/9/19 15:34
 */
public interface CityService {
    void saveCityByJpa(CityEntity cityEntity);
    void saveCityByMybatis(MybatisCityEntity mybatisCityEntity);
}
