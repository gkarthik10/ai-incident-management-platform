package com.karthik.incidentmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DashboardStatsDto {

    private long totalIncidents;
    private long openIncidents;
    private long resolvedIncidents;
    private long highSeverityIncidents;
}