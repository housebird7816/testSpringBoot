package com.oakhit.test.queue;

import com.oakhit.test.bean.BaseBean;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitReceiver {

    @RabbitHandler
    @RabbitListener(queues = "hello", containerFactory = "rabbitListenerContainerFactory")
    public void process(BaseBean baseBean) {
        System.out.println("Receiver  : " + baseBean);
    }
}
