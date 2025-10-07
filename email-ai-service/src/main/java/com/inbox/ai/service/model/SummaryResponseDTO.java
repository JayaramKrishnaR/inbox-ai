package com.inbox.ai.service.model;


import lombok.*;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SummaryResponseDTO {
    private UUID emailId;
    private String summary;
    private String highlights;
    private Map<String, String> suggestedReplies;
    private Instant createdAt;
}
