package com.karthik.incidentmanagement.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.karthik.incidentmanagement.dto.AiResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    public AiResponseDto parseResponse(String response) {

        String category = "";
        String severity = "";
        String recommendation = "";

        for (String line : response.split("\n")) {

            if (line.startsWith("Category:")) {
                category = line.replace("Category:", "").trim();
            }

            if (line.startsWith("Severity:")) {
                severity = line.replace("Severity:", "").trim();
            }

            if (line.startsWith("Recommendation:")) {
                recommendation =
                        line.replace("Recommendation:", "").trim();
            }
        }

        return new AiResponseDto(
                category,
                severity,
                recommendation
        );
    }

    public AiResponseDto analyzeIncident(String description) {

        try {

            String url =
                    "https://api.groq.com/openai/v1/chat/completions";

            String prompt = """
You are a Senior Site Reliability Engineer.

Analyze the incident and return ONLY in this format:

Category: <Database|Network|Application|Security|Infrastructure>

Severity: <LOW|MEDIUM|HIGH|CRITICAL>

Recommendation: <short recommendation>

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

            String content = root
                    .path("choices")
                    .get(0)
                    .path("message")
                    .path("content")
                    .asText();
            return parseResponse(content);

        }
            catch (Exception e) {

                e.printStackTrace();

                return new AiResponseDto(
                        "Unknown",
                        "MEDIUM",
                        "AI service temporarily unavailable. Check logs and investigate manually."
                );
            }
    }
}