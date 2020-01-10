package com.oakhit.test.queue;

import com.oakhit.test.bean.configs.FanoutRabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutReceiverC {
    @RabbitHandler
    @RabbitListener(queues = FanoutRabbitConfig.FANOUT_C)
    public void process(String content) {
        System.out.println("ReceiverC  : " + content);
    }
}
