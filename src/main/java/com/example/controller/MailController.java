package com.example.controller;

import com.example.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mails")
public class MailController {

    @Autowired
    public MessageService service;

    @PostMapping("/{address}")
    public void sendMessage(@PathVariable String address) {
        service.sendMessage(address);
    }

}
