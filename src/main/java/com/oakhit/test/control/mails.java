package com.oakhit.test.control;

import com.oakhit.test.bean.SendMailBean;
import com.oakhit.test.dao.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail/")
public class mails {

    @Autowired
    private MailService mailService;

    @PostMapping("send")
    public String send(@RequestBody SendMailBean mail) {
        return mailService.sendSimpleMail(mail.getToAddr(), mail.getSubject(), mail.getContent());
    }

}
