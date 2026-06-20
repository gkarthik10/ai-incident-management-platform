package com.karthik.incidentmanagement.controller;

import com.karthik.incidentmanagement.dto.DashboardStatsDto;
import com.karthik.incidentmanagement.entity.Severity;
import com.karthik.incidentmanagement.entity.Status;
import com.karthik.incidentmanagement.repository.IncidentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final IncidentRepository incidentRepository;

    @GetMapping("/stats")
    public DashboardStatsDto getStats() {

        return new DashboardStatsDto(
                incidentRepository.count(),
                incidentRepository.countByStatus(Status.OPEN),
                incidentRepository.countByStatus(Status.RESOLVED),
                incidentRepository.countBySeverity(Severity.HIGH)
        );
    }
}