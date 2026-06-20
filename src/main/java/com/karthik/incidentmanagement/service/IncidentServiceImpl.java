package com.karthik.incidentmanagement.service;

import com.karthik.incidentmanagement.dto.IncidentRequestDto;
import com.karthik.incidentmanagement.dto.UpdateStatusDto;
import com.karthik.incidentmanagement.entity.Incident;
import com.karthik.incidentmanagement.entity.Status;
import com.karthik.incidentmanagement.exception.IncidentNotFoundException;
import com.karthik.incidentmanagement.repository.IncidentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IncidentServiceImpl implements IncidentService {

    private final IncidentRepository incidentRepository;

    @Override
    public Incident createIncident(IncidentRequestDto dto) {

        Incident incident = Incident.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .severity(dto.getSeverity())
                .status(Status.OPEN)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        return incidentRepository.save(incident);
    }

    @Override
    public Incident getIncidentById(Long id) {

        return incidentRepository.findById(id)
                .orElseThrow(() ->
                        new IncidentNotFoundException(
                                "Incident not found with id: " + id
                        ));
    }

    @Override
    public void deleteIncident(Long id) {

        Incident incident = incidentRepository.findById(id)
                .orElseThrow(() ->
                        new IncidentNotFoundException(
                                "Incident not found with id: " + id
                        ));

        incidentRepository.delete(incident);
    }

    @Override
    public List<Incident> getAllIncidents() {
        return incidentRepository.findAll();
    }

    @Override
    public Incident updateStatus(
            Long id,
            UpdateStatusDto dto
    ) {

        Incident incident = incidentRepository.findById(id)
                .orElseThrow(() ->
                        new IncidentNotFoundException(
                                "Incident not found with id: " + id
                        ));

        incident.setStatus(dto.getStatus());
        incident.setUpdatedAt(LocalDateTime.now());

        return incidentRepository.save(incident);
    }
}