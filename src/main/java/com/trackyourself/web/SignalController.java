package com.trackyourself.web;

import java.security.Principal;
import java.util.List;

import com.trackyourself.dao.SignalDAO;
import com.trackyourself.domain.Signal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignalController {
  private SignalDAO signalDAO;
  
  @Autowired
  public SignalController(SignalDAO signalDAO) {
    this.signalDAO = signalDAO;
  }
  
  @GetMapping("/signals")
  public List<Signal> getSignal(Principal principal) {
    return signalDAO.findSignalByUsername(principal.getName());
  }
  
  @PostMapping("/signal")
  public void saveSignal(@RequestBody Signal signal, Principal principal) {
    signalDAO.save(signal, principal.getName());
  }
}
