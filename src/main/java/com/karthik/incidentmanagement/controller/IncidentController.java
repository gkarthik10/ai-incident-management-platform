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

    @PreAuthorize("hasAnyRole('ADMIN','EMPLOYEE')")
    @PostMapping
    public Incident createIncident(
            @Valid @RequestBody IncidentRequestDto dto) {

        return incidentService.createIncident(dto);
    }

    @PreAuthorize("hasAnyRole('ADMIN','ENGINEER','EMPLOYEE')")
    @GetMapping
    public List<Incident> getAllIncidents() {
        return incidentService.getAllIncidents();
    }

    @PreAuthorize("hasAnyRole('ADMIN','ENGINEER','EMPLOYEE')")
    @GetMapping("/{id}")
    public Incident getIncidentById(
            @PathVariable Long id) {

        return incidentService.getIncidentById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public String deleteIncident(
            @PathVariable Long id) {

        incidentService.deleteIncident(id);

        return "Incident deleted successfully";
    }

    @PreAuthorize("hasAnyRole('ADMIN','ENGINEER')")
    @PutMapping("/{id}/status")
    public Incident updateStatus(
            @PathVariable Long id,
            @Valid @RequestBody UpdateStatusDto dto
    ) {

        return incidentService.updateStatus(id, dto);
    }
}