package com.oakhit.test.bean.task;

import com.oakhit.test.dao.MailService;
import com.oakhit.test.queue.RabbitSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Scheduler2Task {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private MailService mailService;
    @Autowired
    private RabbitSender rabbitSender;

    @Scheduled(fixedRate = 6000 * 60)
    public void reportCurrentTime() {
        System.out.println("现在时间：" + dateFormat.format(new Date()));
//        mailService.sendSimpleMail("chrisking1995@163.com", "鑫鑫垃圾", "这是测试鑫鑫垃圾的");
//        rabbitSender.send(mail);
//        rabbitSender.sendTopic1();
//        rabbitSender.sendTopic2();
        rabbitSender.sendFanout();
    }

}