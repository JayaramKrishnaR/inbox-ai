package com.inbox.ai.service;



import com.inbox.ai.service.model.EmailEvent;
import com.inbox.ai.service.model.SummaryDocument;
import com.inbox.ai.service.repository.SummaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AIProcessorService {

    private final SummaryRepository summaryRepository;
    private final OpenAIClient openAIClient; // adapt to exact ChatClient type if using spring-ai ChatClient

    public void processEmailEvent(EmailEvent event) {
        try {
            // 1) Summarize (short)
            String summaryPrompt = "Summarize the following email in 2-3 sentences and list 3 key highlights:\n\n"
                    + "Subject: " + event.getSubject() + "\n\n"
                    + event.getBody();

            String summary = callChatModel(summaryPrompt);

            // 2) Extract highlights (could be parsed from model or use structured call)
            // for demo keep as part of summary or parse out lines starting with '-'
            String highlights = extractHighlightsFrom(summary);

            // 3) Generate replies for tones
            Map<String, String> replies = new HashMap<>();
            replies.put("formal", callChatModel("Write a short formal reply to this email:\n\n" + event.getBody()));
            replies.put("informal", callChatModel("Write a short informal reply to this email:\n\n" + event.getBody()));
            replies.put("custom", callChatModel("Write a concise friendly reply to this email (one line):\n\n" + event.getBody()));

            // 4) Save to Mongo
            SummaryDocument doc = SummaryDocument.builder()
                    .emailId(event.getId())
                    .summary(summary)
                    .highlights(highlights)
                    .suggestedReplies(replies)
                    .createdAt(Instant.now())
                    .build();

            summaryRepository.save(doc);

        } catch (Exception ex) {
            // handle/log errors, possibly push to DLQ or store failure record
            ex.printStackTrace();
        }
    }

    private String callChatModel(String prompt) {
        return openAIClient.create(prompt); // adapt to actual API
    }

    private String extractHighlightsFrom(String summary) {
        return summary; // or parse
    }
}

