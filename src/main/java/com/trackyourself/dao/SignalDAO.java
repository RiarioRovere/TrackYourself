package com.trackyourself.dao;

import java.util.List;

import com.trackyourself.domain.Signal;
import com.trackyourself.repository.SignalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SignalDAO {
  private final SignalRepository repository;
  
  @Autowired
  public SignalDAO(SignalRepository repository) {
    this.repository = repository;
  }
  
  public void save(Signal signal, String username) {
    repository.save(signal.withUsername(username));
  }
  
  public List<Signal> findSignalByUsername(String username) {
    return repository.findSignalsByUsername(username);
  }
}
