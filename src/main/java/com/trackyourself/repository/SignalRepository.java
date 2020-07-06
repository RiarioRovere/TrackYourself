package com.trackyourself.repository;

import java.util.List;

import com.trackyourself.domain.Signal;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignalRepository extends MongoRepository<Signal, ObjectId> {
  List<Signal> findSignalsByUsername(String username);
}
