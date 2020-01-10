package com.oakhit.test.queue;

import com.oakhit.test.bean.configs.TopicRabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitReceiver1 {

    @RabbitHandler
    @RabbitListener(queues = TopicRabbitConfig.message)
    public void process(String content) {
        System.out.println("Receiver1  : " + content);
    }
}
