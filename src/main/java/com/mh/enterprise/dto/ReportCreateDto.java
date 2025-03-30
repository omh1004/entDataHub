package com.mh.enterprise.dto;

import com.mh.enterprise.entity.Report;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportCreateDto {
    @NotBlank(message = "Report name is required")
    @Size(max = 100, message = "Name must be less than 100 characters")
    private String name;

    @Size(max = 500, message = "Description must be less than 500 characters")
    private String description;

    private String query;

    @NotNull(message = "Data source ID is required")
    private Long dataSourceId;

    @NotNull(message = "Schedule type is required")
    private Report.ScheduleType scheduleType;

    private String scheduleExpression;

    @Builder.Default
    private boolean enabled = true;
}