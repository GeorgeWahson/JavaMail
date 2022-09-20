package com.example.service.impl;

import com.example.service.SendMailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Arrays;

@Service
@Slf4j
public class SendMailServiceImpl implements SendMailService {

    @Autowired
    private JavaMailSender javaMailSender;

    //发送人
    private String from = "george@163.com";
    //发送人昵称
    private String nickName = "(国家安全委员会)";
    //接收人
    private String toFirst = "george@qq.com";
//    private String toSecond = "test@qq.com";
    // 抄送（也会收到邮件，并且收到邮件的人都能看到）
    private String toCC = "george@gmail.com";
    // 密送（也会收到邮件，但收件人和抄送人看不到）
    private String toBCC = "6@qq.com";
    //标题
    private String subject = "您涉及违反国家安全法";
    //正文

    private String simple_context = "请立即到公安局投案自首，否则将被列为红色嫌疑人并进行全网通缉！";

    // html正文
    private String complex_context = "<img src='https://p1.ssl.qhimg.com/t0146b8a998702d6450.png'/>"
            + simple_context +
            "<a href='https://www.bilibili.com/video/BV1GJ411x7h7'>错误收到邮件？点击申诉</a>";

    @Override
    public void sendSimpleMail() {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from + nickName);
        // 可以传入多个string参数，设置多个发件人
        message.setTo(toFirst);
        // message.setTo(toFirst, toSecond);
        message.setCc(toCC);
        message.setBcc(toBCC);
        message.setSubject(subject);
        message.setText(simple_context);

        javaMailSender.send(message);
        log.info("已发送一次【普通】邮件给：" + Arrays.toString(message.getTo()));
    }

    @Override
    public void sendComponentMail() {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(from + nickName);
            helper.setTo(toFirst);
            helper.setSubject(subject);
            helper.setText(complex_context, true);

            // 添加附件（绝对路径或相对路径）
            File f1 = new File("src/main/resources/中华人民共和国国家安全法.doc");
            File f2 = new File("src/main/resources/Text.png");

            // 设置附件名称
            helper.addAttachment(f1.getName(), f1);
            // 手动设置名称记得加后缀
            helper.addAttachment("中华人民共和国国家安全法（主席令第二十九号）.png", f1);

            javaMailSender.send(message);
            log.info("已发送一次【复杂】邮件给：" + Arrays.toString(message.getAllRecipients()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}