package com.trackyourself.repository;

import java.util.List;

import com.trackyourself.domain.Goal;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GoalRepository extends MongoRepository<Goal, String> {
  List<Goal> findByUsername(String username);
  
  void deleteById(String id);
}
