package com.inbox.ai.service.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

@Document(collection = "summaries")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SummaryDocument {
    @Id
    private String id;                 // mongo id
    private UUID emailId;              // link to email
    private String summary;
    private String highlights;         // could be JSON string or list; simplified here
    private Map<String, String> suggestedReplies; // tone -> reply
    private Instant createdAt;
}
