package com.trackyourself.repository;

import com.trackyourself.domain.DailySummary;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SummaryRepository extends MongoRepository<DailySummary, ObjectId> {
  DailySummary findByUsernameAndDate(String username, String date);
  
  void deleteByUsernameAndDate(String username, String date);
}
