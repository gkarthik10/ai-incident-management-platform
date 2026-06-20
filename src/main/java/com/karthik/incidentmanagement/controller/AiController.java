package com.karthik.incidentmanagement.controller;

import com.karthik.incidentmanagement.dto.AiRequestDto;
import com.karthik.incidentmanagement.dto.AiResponseDto;
import com.karthik.incidentmanagement.service.AiService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
@RequiredArgsConstructor
public class AiController {

    private final AiService aiService;

    @PostMapping("/analyze")
    public AiResponseDto analyze(
            @Valid @RequestBody AiRequestDto dto) {

        return aiService.analyze(
                dto.getDescription());
    }
}