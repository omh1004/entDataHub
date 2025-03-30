package com.mh.enterprise.dto;

import com.mh.enterprise.entity.Dashboard;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DashboardDto {
    private Long id;
    private String name;
    private String description;
    private Long ownerId;
    private String ownerName;
    private boolean isPublic;
    private List<WidgetDto> widgets;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static DashboardDto fromEntity(Dashboard dashboard) {
        return DashboardDto.builder()
                .id(dashboard.getId())
                .name(dashboard.getName())
                .description(dashboard.getDescription())
                .ownerId(dashboard.getOwner().getId())
                .ownerName(dashboard.getOwner().getFullName())
                .isPublic(dashboard.isPublic())
                .widgets(dashboard.getWidgets().stream()
                        .map(WidgetDto::fromEntity)
                        .collect(Collectors.toList()))
                .createdAt(dashboard.getCreatedAt())
                .updatedAt(dashboard.getUpdatedAt())
                .build();
    }

    public static DashboardDto fromEntityWithoutWidgets(Dashboard dashboard) {
        return DashboardDto.builder()
                .id(dashboard.getId())
                .name(dashboard.getName())
                .description(dashboard.getDescription())
                .ownerId(dashboard.getOwner().getId())
                .ownerName(dashboard.getOwner().getFullName())
                .isPublic(dashboard.isPublic())
                .createdAt(dashboard.getCreatedAt())
                .updatedAt(dashboard.getUpdatedAt())
                .build();
    }
}