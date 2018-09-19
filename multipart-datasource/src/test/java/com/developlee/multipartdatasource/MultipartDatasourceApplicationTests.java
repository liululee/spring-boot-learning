package com.developlee.multipartdatasource;

import com.developlee.multipartdatasource.dao.jpa.primary.UserRepository;
import com.developlee.multipartdatasource.entity.jpa.primary.UserEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultipartDatasourceApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    UserRepository userRepository;
    @Test
    public void multipart(){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setMobile("13738718660");
        userEntity.setPassword("123456a");
        userEntity.setUsername("LENSEN");
        Assert.assertEquals(1, userRepository.save(userEntity));
        Assert.assertEquals(1, userRepository.findUserEntityById(1L));
    }

}
