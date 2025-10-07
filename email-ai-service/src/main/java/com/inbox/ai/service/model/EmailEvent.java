package com.inbox.ai.service.model;


import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailEvent {
    private UUID id;
    private String sender;
    private String recipient;
    private String subject;
    private String body;
    private LocalDateTime createdAt;
}
