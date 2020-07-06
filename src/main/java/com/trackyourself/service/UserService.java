package com.trackyourself.service;

import com.trackyourself.domain.Users;
import com.trackyourself.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  private final UserRepository repository;
  private final PasswordEncoder passwordEncoder;
  
  @Autowired
  public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
    this.repository = repository;
    this.passwordEncoder = passwordEncoder;
  }
  
  public void register(Users user) {
    user.setPassword(passwordEncoder.encode(user.password));
    if (repository.findUserByUsername(user.getUsername()) == null) {
      repository.save(user);
    }
  }
}
