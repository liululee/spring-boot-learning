package com.developlee.activemq.producerAndCustomer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class Customer {

    @JmsListener(destination = "test.queue")
    public void receiveMsg(String text) {
        System.out.println("收到消息：" + text);
    }
}
