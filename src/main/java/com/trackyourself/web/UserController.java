package com.trackyourself.web;

import java.security.Principal;

import com.trackyourself.domain.Users;
import com.trackyourself.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
  private final UserService userService;
  
  public UserController(UserService userService) {
    this.userService = userService;
  }
  
  @GetMapping("/user/is_logged_in")
  public ResponseEntity<HttpStatus> isLoggedIn(Principal principal) {
    if (principal == null) {
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
    return new ResponseEntity<>(HttpStatus.OK);
  }
  
  @PostMapping("/user/register")
  public void register(@RequestBody Users user) {
    this.userService.register(user);
  }
}
