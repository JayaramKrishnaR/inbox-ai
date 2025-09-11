package com.inbox.ai.ingestion.service;

import com.inbox.ai.ingestion.model.Emails;

import java.util.List;
import java.util.UUID;

public interface EmailService {

    Emails saveEmail(Emails emails);

    Emails getEmailById(UUID id);

    List<Emails> getAllEmails();
}
