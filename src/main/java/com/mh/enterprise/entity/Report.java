package com.mh.enterprise.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "edh_reports")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Report extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "report_seq")
    @SequenceGenerator(name = "report_seq", sequenceName = "edh_report_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @Column(columnDefinition = "CLOB")  // TEXT를 CLOB으로 변경
    private String query;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "data_source_id")
    private DataSource dataSource;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User creator;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ScheduleType scheduleType;

    @Column
    private String scheduleExpression;

    @Column
    private LocalDateTime lastRun;

    @Column
    private boolean enabled;

    public enum ScheduleType {
        NONE, ONCE, DAILY, WEEKLY, MONTHLY, CUSTOM
    }
}