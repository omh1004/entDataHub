package com.mh.enterprise.repository;

import com.mh.enterprise.entity.Dashboard;
import com.mh.enterprise.entity.Widget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WidgetRepository extends JpaRepository<Widget, Long> {

    List<Widget> findByDashboard(Dashboard dashboard);

    List<Widget> findByDashboardOrderByPositionYAscPositionXAsc(Dashboard dashboard);

    void deleteByDashboard(Dashboard dashboard);
}