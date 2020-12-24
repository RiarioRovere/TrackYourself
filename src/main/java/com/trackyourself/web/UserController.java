package com.trackyourself.web;

import java.security.Principal;
import java.util.List;

import com.trackyourself.domain.Users;
import com.trackyourself.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

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

  @GetMapping("/user/search")
  public List<Users> search(@RequestParam String text) {
    return userService.search(text);
  }
}
