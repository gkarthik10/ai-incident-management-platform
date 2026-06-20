package com.karthik.incidentmanagement.repository;

import com.karthik.incidentmanagement.entity.Incident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidentRepository extends JpaRepository<Incident, Long> {
}