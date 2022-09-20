package com.example.bean;

import com.example.service.SendMailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AutoSend {

    @Autowired
    private SendMailService service;

    public static int number = 1;

    // 从0秒开始，每隔20秒执行一次。  分 时  日 月 星期几
    @Scheduled(cron = "0/20 * * * * ?")
    public void keepSending() {
        service.sendComponentMail();
        log.info("已发送 " + (number++) + " 次");
    }
}
