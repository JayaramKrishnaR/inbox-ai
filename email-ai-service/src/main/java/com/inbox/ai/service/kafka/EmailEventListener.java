package com.inbox.ai.service.kafka;


import com.inbox.ai.service.AIProcessorService;
import com.inbox.ai.service.model.EmailEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailEventListener {

    private final AIProcessorService aiProcessorService;

    @KafkaListener(topics = "${app.kafka.topic.email-new}", groupId = "mail-ai-consumer-group")
    public void onMessage(EmailEvent event) {
        // Best-effort: delegate processing to service
        aiProcessorService.processEmailEvent(event);
    }
}
