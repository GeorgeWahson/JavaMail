package com.example.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class RabbitConfigTopic {

    // amqp的包 消息队列
    @Bean
    public Queue topicQuene() {
        return new Queue("topic_queue");
    }

    // 交换机
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("topicExchange");
    }

    @Bean
    public Binding bingingTopic() {
        return BindingBuilder.bind(topicQuene()).to(topicExchange()).with("topic.*.address");
    }






}
