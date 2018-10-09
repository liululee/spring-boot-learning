package com.developlee.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String DEFAULT_MAIL_QUEUE = "dev.mail.register.default.queue";

    public static final String MANUAL_MAIL_QUEUE = "dev.mail.register.manual.queue";

    @Bean
    public Queue defaultMailQueue (){
        // Queue queue = new  Queue(Queue名称，消息是否需要持久化处理)
        return new Queue(DEFAULT_MAIL_QUEUE, true);
    }

    @Bean
    public Queue manualMailQueue(){
        return new Queue(MANUAL_MAIL_QUEUE, true);
    }
}
