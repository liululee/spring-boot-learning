package com.developlee.multipartmybatisdatasource;

import com.developlee.multipartmybatisdatasource.entity.primary.UserEntity;
import com.developlee.multipartmybatisdatasource.entity.secondary.HomeEntity;
import com.developlee.multipartmybatisdatasource.service.impl.HomeServiceImpl;
import com.developlee.multipartmybatisdatasource.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultipartMybatisDatasourceApplicationTests {

    @Autowired
    UserServiceImpl userService;
    @Autowired
    HomeServiceImpl homeService;

    @Test
    public void contextLoads() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setName("Lensen");
        userEntity.setMobile("13738718660");
        HomeEntity homeEntity = new HomeEntity();
        homeEntity.setId(1L);
        homeEntity.setUserId(1L);
        homeEntity.setCity("杭州");
        homeEntity.setTown("西湖区");

        userService.saveUser(userEntity);
        homeService.saveHome(homeEntity);

        userService.getUserById(1L);
        homeService.getHomeByUserId(1L);
    }

}
