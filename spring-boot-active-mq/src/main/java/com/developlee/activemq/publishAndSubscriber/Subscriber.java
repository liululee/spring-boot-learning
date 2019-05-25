package com.developlee.activemq.publishAndSubscriber;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class Subscriber {

    @JmsListener(destination = "test.topic", containerFactory = "jmsListenerContainerFactory")
    public void subscribe(String text) {
        System.out.println("收到订阅信息：" + text);
    }
}
