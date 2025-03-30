package com.mh.enterprise.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "edh_data_sources")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DataSource extends BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "datasource_seq")
    @SequenceGenerator(name = "datasource_seq", sequenceName = "datasource_seq", allocationSize = 1)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;

    @Column
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DataSourceType type;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String connectionString;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private boolean enabled;

    public enum DataSourceType {
        DATABASE, API, FILE_SYSTEM, EXTERNAL_SERVICE
    }
}