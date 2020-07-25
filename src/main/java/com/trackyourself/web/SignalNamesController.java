package com.trackyourself.web;

import java.security.Principal;
import java.util.List;

import com.trackyourself.dao.SignalNameDAO;
import com.trackyourself.domain.SignalName;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignalNamesController {
  private final SignalNameDAO signalNameDAO;
  
  public SignalNamesController(SignalNameDAO signalNameDAO) {
    this.signalNameDAO = signalNameDAO;
  }
  
  @DeleteMapping("/signal-name")
  public void deleteSignalName(@RequestBody SignalName signalName, Principal principal) {
    signalNameDAO.remove(principal.getName(), signalName.getName());
  }
  
  @PostMapping("/signal-name")
  public void saveSignalName(@RequestBody SignalName signalName, Principal principal) {
    signalNameDAO.save(principal.getName(), signalName.getName());
  }
  
  @GetMapping("/signal-name")
  public List<SignalName> getSignalNames(Principal principal) {
    return signalNameDAO.find(principal.getName());
  }
}
