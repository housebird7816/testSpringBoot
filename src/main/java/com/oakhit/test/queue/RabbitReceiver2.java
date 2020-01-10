package com.oakhit.test.queue;

import com.oakhit.test.bean.configs.TopicRabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitReceiver2 {

    @RabbitHandler
    @RabbitListener(queues = TopicRabbitConfig.messages)
    public void process(String content) {
        System.out.println("Receiver2  : " + content);
    }
}
