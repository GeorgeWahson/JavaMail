package com.example.service;

public interface SendMailService {
    // 发送纯文本邮件（可以来发验证码）
    public void sendSimpleMail();
    // 可以添加附件，网页超链接，图片等
    public void sendComponentMail();
}
