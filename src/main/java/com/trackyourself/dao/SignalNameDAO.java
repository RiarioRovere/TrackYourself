package com.trackyourself.dao;

import java.util.List;

import com.trackyourself.domain.SignalName;
import com.trackyourself.repository.SignalNamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SignalNameDAO {
  private final SignalNamesRepository repository;
  
  @Autowired
  public SignalNameDAO(SignalNamesRepository repository) {
    this.repository = repository;
  }
  
  public List<SignalName> find(String username) {
    return repository.findByUsername(username);
  }
  
  public void remove(String username, String name) {
    repository.deleteByUsernameAndName(username, name);
  }
  
  public void save(String username, String name) {
    repository.save(new SignalName().withName(name).withUsername(username));
  }
}
