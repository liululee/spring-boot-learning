package com.developlee.multipartdatasource.dao.mybatis.master;

import com.developlee.multipartdatasource.entity.mybatis.master.MybatisUserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    void save(MybatisUserEntity mybatisUserEntity);
}
