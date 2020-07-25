package com.trackyourself.web;

import java.security.Principal;
import java.util.List;

import com.trackyourself.dao.SignalDAO;
import com.trackyourself.domain.Signal;
import com.trackyourself.domain.SignalName;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
  
  @PostMapping("/signals")
  public void saveSignal(@RequestBody List<Signal> signals, Principal principal) {
    signalDAO.save(signals, principal.getName());
  }
  
  @Data
  private static class DeleteRequest {
    private String name;
    private String date;
  }
  
  @DeleteMapping("/signals")
  public void deleteSignalName(@RequestBody DeleteRequest deleteRequest, Principal principal) {
    signalDAO.delete(principal.getName(), deleteRequest.getName(), deleteRequest.getDate());
  }
}
