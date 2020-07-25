package com.trackyourself.web;

import java.security.Principal;

import com.trackyourself.dao.SummaryDAO;
import com.trackyourself.domain.DailySummary;
import lombok.Data;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SummaryController {
  private final SummaryDAO summaryDAO;
  
  public SummaryController(SummaryDAO summaryDAO) {
    this.summaryDAO = summaryDAO;
  }
  
  @Data
  private static class Request {
    private String date;
    private String summary;
  }
  
  @DeleteMapping("/summary")
  public void delete(@RequestBody Request request, Principal principal) {
    summaryDAO.delete(principal.getName(), request.getDate());
  }
  
  @PostMapping("/summary")
  public void save(@RequestBody Request request, Principal principal) {
    summaryDAO.save(principal.getName(), request.getSummary(), request.getDate());
  }
  
  @GetMapping("/summary")
  public DailySummary get(@RequestParam String date, Principal principal) {
    return summaryDAO.find(principal.getName(), date);
  }
}
