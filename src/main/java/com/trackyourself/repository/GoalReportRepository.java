package com.trackyourself.repository;


import java.util.List;

import com.trackyourself.domain.GoalReport;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GoalReportRepository extends MongoRepository<GoalReport, String> {
  List<GoalReport> findByGoalIdOrderByDate(String goalId);
  
  GoalReport deleteByIdAndUsername(String id, String username);
}
