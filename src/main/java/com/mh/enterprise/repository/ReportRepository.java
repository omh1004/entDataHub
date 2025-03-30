package com.mh.enterprise.repository;

import com.mh.enterprise.entity.DataSource;
import com.mh.enterprise.entity.Report;
import com.mh.enterprise.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

    List<Report> findByCreator(User creator);

    List<Report> findByDataSource(DataSource dataSource);

    List<Report> findByEnabledAndScheduleTypeNot(boolean enabled, Report.ScheduleType scheduleType);

    @Query("SELECT r FROM Report r WHERE r.enabled = true AND r.lastRun IS NULL OR r.lastRun < :timestamp")
    List<Report> findDueReports(@Param("timestamp") LocalDateTime timestamp);

    @Query("SELECT r FROM Report r WHERE " +
            "LOWER(r.name) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
            "LOWER(r.description) LIKE LOWER(CONCAT('%', :search, '%'))")
    Page<Report> searchReports(@Param("search") String search, Pageable pageable);
}