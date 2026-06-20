package com.karthik.incidentmanagement.service;

import com.karthik.incidentmanagement.dto.AiResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AiServiceImpl implements AiService {

    private final AiProviderService aiProviderService;

    @Override
    public AiResponseDto analyze(String description) {

        String result =
                aiProviderService.analyzeIncident(description);

        return new AiResponseDto(result);
    }
}