package com.inbox.ai.service.repository;



import com.inbox.ai.service.model.SummaryDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface SummaryRepository extends MongoRepository<SummaryDocument, String> {
    Optional<SummaryDocument> findByEmailId(UUID emailId);
}
