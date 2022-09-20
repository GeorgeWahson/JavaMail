package com.example.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @RabbitListener(queues = "topic_queue")
    public void receive(String address){
        System.out.println("已完成邮件发送业务，address： "+ address);
    }
}
