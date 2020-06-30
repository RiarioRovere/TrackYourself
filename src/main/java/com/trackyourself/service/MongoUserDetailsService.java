//package com.trackyourself.service;
//
//import java.util.Collections;
//import java.util.List;
//
//import com.trackyourself.domain.Users;
//import com.trackyourself.repository.UserRepository;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//@Component
//public class MongoUserDetailsService implements UserDetailsService {
//  private final UserRepository repository;
//  
//  public MongoUserDetailsService(UserRepository repository) {
//    this.repository = repository;
//  }
//  
//  @Override
//  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//    Users users = repository.findUserByUsername(username);
//    
//    if (users == null) {
//      throw new UsernameNotFoundException("User not found");
//    }
//    
//    List<SimpleGrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("user"));
//    return new User(users.getUsername(), users.getPassword(), authorities);
//  }
//}
