package com.example;

import com.example.service.SendMailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TaskWithMailApplicationTests {

    @Autowired
    private SendMailService service;

    @Test
    void testSendSimpleMessage() {
        service.sendSimpleMail();
    }

    @Test
    void testSendComponentMessage() {
        service.sendComponentMail();
    }

}
