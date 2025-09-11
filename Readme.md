# 📧 InboxAI – Smart Email Summarization & Replies

InboxAI is a backend project that connects to an email ingestion system, processes emails through AI, and generates **concise summaries, highlights, and suggested replies** in different tones (formal, informal, custom).  

The system is built using **Spring Boot, Kafka, Postgres, MongoDB, and Spring AI** in a **microservices architecture**.

---

## 🚀 Overview

- **Email Ingestion Service**  
  - Exposes REST APIs to ingest emails.  
  - Persists emails in **Postgres**.  
  - Publishes new email events to **Kafka**.  

- **Email AI Service**  
  - Consumes email events from Kafka.  
  - Uses **Spring AI + LLMs (OpenAI or any provider)** to generate:  
    - Summary of email  
    - Key highlights  
    - Suggested replies in multiple tones  
  - Persists results in **MongoDB**.  
  - Exposes REST API to fetch AI-processed summaries and replies.  

---

## 🛠️ Tech Stack

- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA** (Postgres)
- **Spring Data MongoDB**
- **Spring Kafka**
- **Spring AI (LLM integration)**
- **Apache Kafka + Zookeeper**
- **PostgreSQL**
- **MongoDB**
- **Docker Compose** (for local infra)

---

## 🗂️ Database Design

### Postgres (Email Ingestion Service)
Table: `emails`

| Column       | Type      | Description             |
|--------------|-----------|-------------------------|
| id           | UUID (PK) | Unique email ID         |
| sender       | VARCHAR   | Email sender address    |
| recipient    | VARCHAR   | Email recipient address |
| subject      | VARCHAR   | Email subject           |
| body         | TEXT      | Email body content      |
| created_at   | TIMESTAMP | Ingestion timestamp     |

---

### MongoDB (Email AI Service)
Collection: `summaries`

```json
{
  "_id": "64abc12345ef...",
  "emailId": "c33fda90-bb24-4c4e-8210-3cfa2b73a999",
  "summary": "Short 2-3 sentence summary of email...",
  "highlights": "Important key points...",
  "suggestedReplies": {
    "formal": "Dear X, ...",
    "informal": "Hey, got it...",
    "custom": "Sure, I'll do it..."
  },
  "createdAt": "2025-09-11T14:20:00Z"
}
