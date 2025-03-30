package com.mh.enterprise.dto;

import com.mh.enterprise.entity.Widget;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WidgetDto {
    private Long id;
    private String title;
    private String description;
    private Widget.WidgetType type;
    private String dataSource;
    private String configuration;
    private Integer positionX;
    private Integer positionY;
    private Integer width;
    private Integer height;
    private Long dashboardId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static WidgetDto fromEntity(Widget widget) {
        return WidgetDto.builder()
                .id(widget.getId())
                .title(widget.getTitle())
                .description(widget.getDescription())
                .type(widget.getType())
                .dataSource(widget.getDataSource())
                .configuration(widget.getConfiguration())
                .positionX(widget.getPositionX())
                .positionY(widget.getPositionY())
                .width(widget.getWidth())
                .height(widget.getHeight())
                .dashboardId(widget.getDashboard().getId())
                .createdAt(widget.getCreatedAt())
                .updatedAt(widget.getUpdatedAt())
                .build();
    }
}