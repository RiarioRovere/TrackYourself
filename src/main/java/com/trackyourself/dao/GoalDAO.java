package com.trackyourself.dao;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import com.trackyourself.domain.Goal;
import com.trackyourself.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GoalDAO {
  private final GoalRepository repository;
  
  @Autowired
  public GoalDAO(GoalRepository repository) {
    this.repository = repository;
  }
  
  public void save(Goal goal, String username) {
    repository.save(goal.withUsername(username).withDate(Date.from(Instant.now())));
  }
  
  public List<Goal> findGoalByUsername(String username) {
    return repository.findByUsername(username);
  }
  
  public Goal findById(String id) {
    return repository.findById(id).orElse(null);
  }
  
  public void deleteById(String id) {
    repository.deleteById(id);
  }
}
