package com.developlee.rabbitmq.handler;

import com.developlee.rabbitmq.config.RabbitMQConfig;
import com.developlee.rabbitmq.entity.MailEntity;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author Lee
 * @// TODO 2018/6/22-11:38
 * @description 消息处理， 默认情况下rabbitMq 是自动ACK机制。 意味着消息处理完毕后会自动去帮我们ACK.
 * 这样依赖会有一个问题: 如果报错了，消息不会丢失，会无限循环消费，很容易把磁盘空间消耗完，可以配置消费次数解决。
 * 推荐做法： 这里我们用手动ACK，将消费错误的消息转移到其他队列中，做补偿处理。
 */
@Component
public class MailHandler {

    private static final Logger logger = LoggerFactory.getLogger(MailHandler.class);

    /**
     * <p>TODO 该方案是 spring-boot-data-amqp 默认的方式,不太推荐。具体推荐使用  listenerManualAck()</p>
     * 默认情况下,如果没有配置手动ACK, 那么Spring Data AMQP 会在消息消费完毕后自动帮我们去ACK
     * 存在问题：如果报错了,消息不会丢失,但是会无限循环消费,一直报错,如果开启了错误日志很容易将磁盘空间耗完
     * 解决方案：手动ACK,或者try-catch 然后在 catch 里面讲错误的消息转移到其它的系列中去
     * spring.rabbitmq.listener.simple.acknowledge-mode=manual
     * <p>
     *
     * @param mail 监听的内容
     */
    @RabbitListener(queues = {RabbitMQConfig.DEFAULT_MAIL_QUEUE})
    public void listenerAutoAck(MailEntity mail, Message message, Channel channel) {
        //TODO  如果手动ACK,消息会被监听消费,但是消息在队列中依旧存在,如果 未配置 acknowledge-mode 默认是会在消费完毕后自动ACK掉
        final long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            logger.info("listenerAutoAck 监听的消息-{}", mail.toString());
            //TODO  通知MQ 消息已被成功消费，可以ACK了
            channel.basicAck(deliveryTag, false);
        } catch (IOException e) {
            //处理失败， 重新压入MQ.
            try {
                channel.basicRecover();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    @RabbitListener(queues = {RabbitMQConfig.MANUAL_MAIL_QUEUE})
    public void listenerManualAck(MailEntity mail, Message message, Channel channel) {
        logger.info("listenerManualAck 监听的消息-{}", mail.toString());
        try {
            //TODO  通知MQ 消息已被成功消费，可以ACK了
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            //如果报错，容错处理，
        }
    }
}