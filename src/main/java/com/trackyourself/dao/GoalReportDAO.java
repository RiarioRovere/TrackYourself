package com.trackyourself.dao;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

import com.trackyourself.domain.GoalReport;
import com.trackyourself.repository.GoalReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GoalReportDAO {
  private final GoalReportRepository repository;
  
  @Autowired
  public GoalReportDAO(GoalReportRepository repository) {
    this.repository = repository;
  }
  
  public void save(GoalReport report, String username) {
    repository.save(report.withUsername(username).withDate(Date.from(Instant.now())));
  }
  
  public List<GoalReport> findGoalReportByGoalId(String goalId) {
    return repository.findByGoalIdOrderByDate(goalId);
  }
  
  public GoalReport findById(String id) {
    return repository.findById(id).orElse(null);
  }
  
  public void deleteByIdAndUsername(String id, String username) {
    repository.deleteByIdAndUsername(id, username);
  }
}
