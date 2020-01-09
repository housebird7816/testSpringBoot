package com.oakhit.test.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class SendMailBean {

    private String toAddr;
    private String subject;
    private String content;
}
