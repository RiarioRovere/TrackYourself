package com.trackyourself.dao;

import java.security.Principal;
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
  
  public List<Goal> findGoalByUsername(String username, String requester) {
    if (requester.equals(username)) {
      return repository.findByUsername(username);
    }
    return findPublicGoalsByUsername(username);
  }

  public List<Goal> findPublicGoalsByUsername(String username) {
    return repository.findByUsernameAndIsPublic(username, true);
  }
  
  public Goal findById(String id) {
    return repository.findById(id).orElse(null);
  }

  public Goal updateGoal(String id, Goal goal, String username) {
    Goal old = repository.findByIdAndUsername(id, username).orElse(null);
    if (old != null) {
      old = old.mergeFrom(goal);
      repository.save(old);
    }
    return old;
  }
  
  public void deleteByIdAndUsername(String id, String username) {
    repository.deleteByIdAndUsername(id, username);
  }
}
