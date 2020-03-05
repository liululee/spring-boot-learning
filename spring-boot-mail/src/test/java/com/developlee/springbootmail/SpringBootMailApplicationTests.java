package com.developlee.springbootmail;

import com.developlee.springbootmail.service.IMailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootMailApplicationTests {

    @Autowired
    private IMailService mailService;

    @Test
    void contextLoads() {
    }

    @Test
    public void sendMail() {
        String to = "729235361@qq.com";
        String subject = "你好，这是我的自我介绍";
        String content = "这是测试第一封邮件，里面是文本消息";
        mailService.sendTextMail(to, subject, content);
    }
}
