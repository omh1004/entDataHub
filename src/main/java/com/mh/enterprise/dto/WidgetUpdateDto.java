package com.mh.enterprise.dto;

import com.mh.enterprise.entity.Widget;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WidgetUpdateDto {
    @Size(max = 100, message = "Title must be less than 100 characters")
    private String title;

    @Size(max = 500, message = "Description must be less than 500 characters")
    private String description;

    private Widget.WidgetType type;

    private String dataSource;

    private String configuration;

    private Integer positionX;

    private Integer positionY;

    private Integer width;

    private Integer height;
}