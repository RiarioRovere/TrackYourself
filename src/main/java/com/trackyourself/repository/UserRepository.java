package com.trackyourself.repository;

import com.trackyourself.domain.Users;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface UserRepository extends MongoRepository<Users, ObjectId> {
  Users findUserByUsername(String username);

//  @Query(value = "{ $query: {username: {$regex: ?0}}, $limit: 2}", fields = "{username: 1}", sort = "{ username : -1 }")
  List<Users> findTop20ByUsernameStartingWith(String regex);
}
