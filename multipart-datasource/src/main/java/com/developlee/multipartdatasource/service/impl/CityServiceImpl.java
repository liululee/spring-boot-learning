package com.developlee.multipartdatasource.service.impl;

import com.developlee.multipartdatasource.dao.jpa.secondary.CityRepository;
import com.developlee.multipartdatasource.dao.mybatis.cluster.CityDao;
import com.developlee.multipartdatasource.entity.jpa.secondary.CityEntity;
import com.developlee.multipartdatasource.entity.mybatis.cluster.MybatisCityEntity;
import com.developlee.multipartdatasource.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Lensen
 * @desc
 * @since 2018/9/19 15:33
 */
@Service
@Slf4j
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    @Autowired
    private CityRepository cityRepository;

    @Override
    public void saveCityByJpa(CityEntity cityEntity) {
        log.info("JPA-Secondary数据源执行save City操作");
        cityRepository.save(cityEntity);
    }

    @Override
    public void saveCityByMybatis(MybatisCityEntity mybatisCityEntity) {
        log.info("Mybatis-Cluster数据源执行save City操作");
        cityDao.save(mybatisCityEntity);
    }
}
