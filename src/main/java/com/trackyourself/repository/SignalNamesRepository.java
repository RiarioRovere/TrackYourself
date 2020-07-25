package com.trackyourself.repository;

import java.util.List;

import com.trackyourself.domain.Signal;
import com.trackyourself.domain.SignalName;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SignalNamesRepository extends MongoRepository<SignalName, ObjectId> {
  List<SignalName> findByUsername(String username);
  
  void deleteByUsernameAndName(String username, String name);
  
//  List<SignalName> findByUsername(String username);
}
