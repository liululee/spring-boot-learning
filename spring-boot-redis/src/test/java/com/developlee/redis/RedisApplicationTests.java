package com.developlee.redis;

import com.developlee.redis.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RedisApplicationTests {

    @Autowired
    UserServiceImpl userService;

    @Test
    public void contextLoads() {
        log.info(userService.findUserById(1L).toString());
    }

}
