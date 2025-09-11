package com.inbox.ai.ingestion.service;

import com.inbox.ai.ingestion.model.Emails;
import com.inbox.ai.ingestion.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    KafkaService kafkaService;

    @Override
    public Emails saveEmail(Emails emails) {
        kafkaService.testMessage("Message Sent For Test");
        return emailRepository.save(emails);
    }

    @Override
    public Emails getEmailById(UUID id) {
        return emailRepository.findById(id).orElse(null);
    }

    @Override
    public List<Emails> getAllEmails() {
        return emailRepository.findAll();
    }
}
