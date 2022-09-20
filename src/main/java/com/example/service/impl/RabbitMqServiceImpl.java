package com.example.service.impl;

import com.example.service.MessageService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqServiceImpl implements MessageService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public void sendMessage(String address) {
        System.out.println("待发送的邮件地址：" + address + "已进入处理队列");
        amqpTemplate.convertAndSend("topicExchange","topic.mail.address", address);
    }
}
