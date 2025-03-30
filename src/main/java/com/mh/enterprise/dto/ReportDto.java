package com.mh.enterprise.dto;

import com.mh.enterprise.entity.Report;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportDto {
    private Long id;
    private String name;
    private String description;
    private String query;
    private Long dataSourceId;
    private String dataSourceName;
    private Long creatorId;
    private String creatorName;
    private Report.ScheduleType scheduleType;
    private String scheduleExpression;
    private LocalDateTime lastRun;
    private boolean enabled;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static ReportDto fromEntity(Report report) {
        return ReportDto.builder()
                .id(report.getId())
                .name(report.getName())
                .description(report.getDescription())
                .query(report.getQuery())
                .dataSourceId(report.getDataSource().getId())
                .dataSourceName(report.getDataSource().getName())
                .creatorId(report.getCreator().getId())
                .creatorName(report.getCreator().getFullName())
                .scheduleType(report.getScheduleType())
                .scheduleExpression(report.getScheduleExpression())
                .lastRun(report.getLastRun())
                .enabled(report.isEnabled())
                .createdAt(report.getCreatedAt())
                .updatedAt(report.getUpdatedAt())
                .build();
    }
}