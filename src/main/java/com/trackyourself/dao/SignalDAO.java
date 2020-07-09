package com.trackyourself.dao;

import java.util.List;
import java.util.stream.Collectors;

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
  
  public void save(final List<Signal> signal, String username) {
    signal.stream().forEach(s -> {
      repository.save(s.withUsername(username));
    });
  }
  
  public List<Signal> findSignalByUsername(String username) {
    return repository.findSignalsByUsername(username);
  }
}
