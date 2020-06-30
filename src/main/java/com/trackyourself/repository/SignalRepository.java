package com.trackyourself.repository;

import java.util.List;

import com.trackyourself.domain.Signal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignalRepository extends CrudRepository<Signal, Long> {
  List<Signal> findSignalsByUsername(String username);
}
