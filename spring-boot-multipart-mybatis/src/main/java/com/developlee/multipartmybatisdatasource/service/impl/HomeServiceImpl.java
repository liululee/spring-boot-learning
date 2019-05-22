package com.developlee.multipartmybatisdatasource.service.impl;

import com.developlee.multipartmybatisdatasource.dao.secondary.HomeDao;
import com.developlee.multipartmybatisdatasource.entity.secondary.HomeEntity;
import com.developlee.multipartmybatisdatasource.service.HomeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Lensen
 * @desc
 * @since 2018/9/19 11:18
 */
@Service
@Slf4j
public class HomeServiceImpl implements HomeService {

    @Autowired
    private HomeDao homeDao;

    @Override
    public int saveHome(HomeEntity homeEntity) {
        log.info("Secondary 数据库对Home Save");
        return homeDao.saveHome(homeEntity);
    }

    @Override
    public HomeEntity getHomeByUserId(Long userId) {
        log.info("Secondary 数据库对Home Get");
        return homeDao.getHomeByUserId(userId);
    }
}
