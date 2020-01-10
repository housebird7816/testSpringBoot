package com.oakhit.test.queue;

import com.oakhit.test.bean.configs.FanoutRabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutReceiverA {
    @RabbitHandler
    @RabbitListener(queues = FanoutRabbitConfig.FANOUT_A)
    public void process(String content) {
        System.out.println("ReceiverA  : " + content);
    }
}
