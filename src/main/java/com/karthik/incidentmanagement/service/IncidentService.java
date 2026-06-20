package com.karthik.incidentmanagement.service;

import com.karthik.incidentmanagement.dto.IncidentRequestDto;
import com.karthik.incidentmanagement.dto.UpdateStatusDto;
import com.karthik.incidentmanagement.entity.Incident;

import java.util.List;

public interface IncidentService {

    Incident createIncident(IncidentRequestDto dto);

    Incident getIncidentById(Long id);

    List<Incident> getAllIncidents();

    void deleteIncident(Long id);

    Incident updateStatus(
            Long id,
            UpdateStatusDto dto
    );
}