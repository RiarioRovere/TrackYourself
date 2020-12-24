package com.trackyourself.repository;

import java.util.List;
import java.util.Optional;

import com.trackyourself.domain.Goal;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GoalRepository extends MongoRepository<Goal, String> {
  List<Goal> findByUsername(String username);

  List<Goal> findByUsernameAndIsPublic(String username, boolean isPublic);

  Optional<Goal> findByIdAndUsername(String id, String username);
  
  void deleteByIdAndUsername(String id, String username);
}
