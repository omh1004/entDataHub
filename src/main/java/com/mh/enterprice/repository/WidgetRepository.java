package com.mh.enterprice.repository;

import com.mh.enterprice.entity.Dashboard;
import com.mh.enterprice.entity.Widget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WidgetRepository extends JpaRepository<Widget, Long> {

    List<Widget> findByDashboard(Dashboard dashboard);

    List<Widget> findByDashboardOrderByPositionYAscPositionXAsc(Dashboard dashboard);

    void deleteByDashboard(Dashboard dashboard);
}