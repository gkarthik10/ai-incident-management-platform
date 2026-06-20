package com.karthik.incidentmanagement.repository;

import com.karthik.incidentmanagement.entity.Incident;
import com.karthik.incidentmanagement.entity.Severity;
import com.karthik.incidentmanagement.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IncidentRepository extends JpaRepository<Incident, Long> {
    long countByStatus(Status status);

    long countBySeverity(Severity severity);
}