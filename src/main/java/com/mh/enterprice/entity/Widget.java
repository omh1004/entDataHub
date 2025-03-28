package com.mh.enterprice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "edh_widgets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Widget extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "widget_seq")
    @SequenceGenerator(name = "widget_seq", sequenceName = "edh_widget_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WidgetType type;

    @Column(nullable = false)
    private String dataSource;

    @Column(columnDefinition = "CLOB")  // TEXT를 CLOB으로 변경
    private String configuration;

    @Column
    private Integer positionX;

    @Column
    private Integer positionY;

    @Column
    private Integer width;

    @Column
    private Integer height;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dashboard_id")
    private Dashboard dashboard;

    public enum WidgetType {
        CHART, TABLE, KPI, TEXT, HEAT_MAP, PIE_CHART, BAR_CHART, LINE_CHART
    }
}