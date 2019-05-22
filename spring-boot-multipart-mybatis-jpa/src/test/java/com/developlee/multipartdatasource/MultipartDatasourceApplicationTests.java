package com.developlee.multipartdatasource;

import com.developlee.multipartdatasource.entity.jpa.primary.UserEntity;
import com.developlee.multipartdatasource.entity.jpa.secondary.CityEntity;
import com.developlee.multipartdatasource.entity.mybatis.cluster.MybatisCityEntity;
import com.developlee.multipartdatasource.entity.mybatis.master.MybatisUserEntity;
import com.developlee.multipartdatasource.service.impl.CityServiceImpl;
import com.developlee.multipartdatasource.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultipartDatasourceApplicationTests {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    CityServiceImpl cityService;


    @Test
    public void contextLoads() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("JPA-Lensen");
        userEntity.setPwd("123456");
        userEntity.setMobile("137****8661");

        CityEntity cityEntity = new CityEntity();
        cityEntity.setUserId(1024L);
        cityEntity.setDescription("JPA-Lensen-Desc");

        MybatisUserEntity mybatisUserEntity = new MybatisUserEntity();
        mybatisUserEntity.setUsername("Mybatis-Lensen");
        mybatisUserEntity.setPwd("654321");
        mybatisUserEntity.setMobile("137****1024");

        MybatisCityEntity mybatisCityEntity = new MybatisCityEntity();
        mybatisCityEntity.setDesc("MyBatis-Lensen-Desc");
        mybatisCityEntity.setUserId(2048L);
        mybatisCityEntity.setId(10L);

        userService.saveUserByJpa(userEntity);
        cityService.saveCityByJpa(cityEntity);
        userService.saveUserByMybatis(mybatisUserEntity);
        cityService.saveCityByMybatis(mybatisCityEntity);

    }

}
