package com.inbox.ai.service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConfig {

    @KafkaListener(topics = "test-topic", groupId = "group1")
    public void receiveMessage(String value) {
        System.out.println("The received message: " + value);
    }
}
