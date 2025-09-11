package com.inbox.ai.ingestion.repository;

import com.inbox.ai.ingestion.model.Emails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmailRepository extends JpaRepository<Emails, UUID> {
}
