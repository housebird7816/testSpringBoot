package com.oakhit.test.dao;

public interface MailService {
    String sendSimpleMail(String to, String subject, String content);
    String sendHtmlMail(String to, String subject, String content);
    String sendAttachmentsMail(String to, String subject, String content, String filePath);
}
