package com.developlee.multipartmybatisdatasource.service;

import com.developlee.multipartmybatisdatasource.entity.secondary.HomeEntity;

public interface HomeService {
    int saveHome(HomeEntity homeEntity);
    HomeEntity getHomeByUserId(Long userId);
}
