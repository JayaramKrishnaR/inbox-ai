package com.inbox.ai.ingestion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public boolean testMessage(String text) {
        this.kafkaTemplate.send("test-topic", text);
        return true;
    }
}
