package com.mh.enterprise.dto;

import com.mh.enterprise.entity.Widget;
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
public class WidgetCreateDto {
    @NotBlank(message = "Widget title is required")
    @Size(max = 100, message = "Title must be less than 100 characters")
    private String title;

    @Size(max = 500, message = "Description must be less than 500 characters")
    private String description;

    @NotNull(message = "Widget type is required")
    private Widget.WidgetType type;

    @NotBlank(message = "Data source is required")
    private String dataSource;

    private String configuration;

    private Integer positionX;

    private Integer positionY;

    private Integer width;

    private Integer height;

    @NotNull(message = "Dashboard ID is required")
    private Long dashboardId;
}