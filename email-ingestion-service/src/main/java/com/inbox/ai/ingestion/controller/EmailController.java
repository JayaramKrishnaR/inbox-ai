package com.inbox.ai.ingestion.controller;

import com.inbox.ai.ingestion.model.Emails;
import com.inbox.ai.ingestion.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/emails")
@RequiredArgsConstructor
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<Emails> addEmail(@RequestBody Emails email) {
        System.out.println(email.toString());
        return ResponseEntity.ok(emailService.saveEmail(email));
    }

    @GetMapping
    public ResponseEntity<List<Emails>> getAllEmails() {
        return ResponseEntity.ok(emailService.getAllEmails());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Emails> getEmailById(@PathVariable UUID id) {
        return ResponseEntity.ok(emailService.getEmailById(id));
    }
}