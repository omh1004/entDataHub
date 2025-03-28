package com.mh.enterprice.repository;

import com.mh.enterprice.entity.Dashboard;
import com.mh.enterprice.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DashboardRepository extends JpaRepository<Dashboard, Long> {

    List<Dashboard> findByOwner(User owner);

    Page<Dashboard> findByOwner(User owner, Pageable pageable);

    @Query("SELECT d FROM Dashboard d WHERE d.isPublic = true OR d.owner = :user")
    Page<Dashboard> findAccessibleDashboards(@Param("user") User user, Pageable pageable);

    @Query("SELECT d FROM Dashboard d WHERE (d.isPublic = true OR d.owner = :user) AND " +
            "(LOWER(d.name) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
            "LOWER(d.description) LIKE LOWER(CONCAT('%', :search, '%')))")
    Page<Dashboard> searchDashboards(@Param("user") User user, @Param("search") String search, Pageable pageable);
}