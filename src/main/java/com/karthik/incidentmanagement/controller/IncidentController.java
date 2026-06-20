package com.karthik.incidentmanagement.controller;

import com.karthik.incidentmanagement.dto.IncidentRequestDto;
import com.karthik.incidentmanagement.dto.UpdateStatusDto;
import com.karthik.incidentmanagement.entity.Incident;
import com.karthik.incidentmanagement.service.IncidentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incidents")
@RequiredArgsConstructor
public class IncidentController {

    private final IncidentService incidentService;

    @PostMapping
    public Incident createIncident(
            @Valid @RequestBody IncidentRequestDto dto) {

        return incidentService.createIncident(dto);
    }

    @GetMapping
    public List<Incident> getAllIncidents() {
        return incidentService.getAllIncidents();
    }

    @GetMapping("/{id}")
    public Incident getIncidentById(
            @PathVariable Long id) {

        return incidentService.getIncidentById(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteIncident(
            @PathVariable Long id) {

        incidentService.deleteIncident(id);

        return "Incident deleted successfully";
    }

    @PutMapping("/{id}/status")
    @PreAuthorize(
            "hasRole('ADMIN') or hasRole('ENGINEER')"
    )
    public Incident updateStatus(
            @PathVariable Long id,
            @Valid @RequestBody UpdateStatusDto dto
    ) {

        return incidentService.updateStatus(id, dto);
    }
}