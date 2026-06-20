package com.karthik.incidentmanagement.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AiProviderService {

    private final RestTemplate restTemplate;

    @Value("${groq.api.key}")
    private String apiKey;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public String analyzeIncident(String description) {

        try {

            String url =
                    "https://api.groq.com/openai/v1/chat/completions";

            String prompt = """
                    You are a Senior Site Reliability Engineer.

                    Analyze the following incident and provide:

                    1. Possible Root Causes
                    2. Impact
                    3. Suggested Resolution Steps

                    Incident:
                    """ + description;

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(apiKey);

            Map<String, Object> requestBody = Map.of(
                    "model", "llama-3.1-8b-instant",
                    "messages", List.of(
                            Map.of(
                                    "role", "user",
                                    "content", prompt
                            )
                    ),
                    "temperature", 0.3
            );

            HttpEntity<Map<String, Object>> entity =
                    new HttpEntity<>(requestBody, headers);

            ResponseEntity<String> response =
                    restTemplate.postForEntity(
                            url,
                            entity,
                            String.class
                    );

            JsonNode root =
                    objectMapper.readTree(response.getBody());

            return root
                    .path("choices")
                    .get(0)
                    .path("message")
                    .path("content")
                    .asText();

        } catch (Exception e) {

            e.printStackTrace();

            return """
                    AI analysis service temporarily unavailable.

                    Possible Root Causes:
                    1. Database connection pool exhausted
                    2. Database unavailable
                    3. Network timeout
                    4. Long-running transactions

                    Impact:
                    - Failed requests
                    - Increased response time
                    - Service degradation

                    Suggested Resolution Steps:
                    1. Check application logs
                    2. Verify database health
                    3. Check connection pool settings
                    4. Review recent deployments
                    5. Monitor system metrics
                    """;
        }
    }
}