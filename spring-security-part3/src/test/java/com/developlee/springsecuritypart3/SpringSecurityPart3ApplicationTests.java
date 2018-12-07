package com.developlee.springsecuritypart3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringSecurityPart3ApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void testMac() {
        String password = "123456";
        System.out.println("加密后密码：" + passwordEncoder.encode(password));
    }
}
