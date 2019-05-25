package com.developlee.activemq.publishAndSubscriber;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;

@Service
public class Publisher {

    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void publish(String destinationName, String message) {
        Destination destination = new ActiveMQQueue(destinationName);
        System.out.println("发布topic消息" + message);
        jmsMessagingTemplate.convertAndSend(destination, message);
    }
}
