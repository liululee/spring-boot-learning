package com.developlee.activemq;

import com.developlee.activemq.producerAndCustomer.JMSProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivemqApplicationTests {

    @Autowired
    private JMSProducer jmsProducer;

    @Test
    public void contextLoads() {
        jmsProducer.sendMsg("test.queue", "Hello, activemq!");
    }


}
