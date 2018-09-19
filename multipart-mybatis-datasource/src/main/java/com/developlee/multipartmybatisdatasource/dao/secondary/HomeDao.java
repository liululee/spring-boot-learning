package com.developlee.multipartmybatisdatasource.dao.secondary;

import com.developlee.multipartmybatisdatasource.entity.secondary.HomeEntity;
import org.springframework.stereotype.Repository;

/**
 * @author Lensen
 * @desc
 * @since 2018/9/19 10:41
 */
@Repository
public interface HomeDao {
    int saveHome(HomeEntity homeEntity);
    HomeEntity getHomeByUserId(Long userId);
}
