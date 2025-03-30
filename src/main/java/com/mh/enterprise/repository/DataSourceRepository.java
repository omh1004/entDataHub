package com.mh.enterprise.repository;

import com.mh.enterprise.entity.DataSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DataSourceRepository extends JpaRepository<DataSource, Long> {

    Optional<DataSource> findByName(String name);

    List<DataSource> findByEnabled(boolean enabled);

    @Query("SELECT ds FROM DataSource ds WHERE " +
            "LOWER(ds.name) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
            "LOWER(ds.description) LIKE LOWER(CONCAT('%', :search, '%'))")
    Page<DataSource> searchDataSources(@Param("search") String search, Pageable pageable);

    List<DataSource> findByType(DataSource.DataSourceType type);
}