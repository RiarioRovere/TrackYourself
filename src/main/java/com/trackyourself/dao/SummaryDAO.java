package com.trackyourself.dao;

import com.trackyourself.domain.DailySummary;
import com.trackyourself.repository.SummaryRepository;
import org.springframework.stereotype.Component;

@Component
public class SummaryDAO {
  private SummaryRepository repository;
  
  public SummaryDAO(SummaryRepository repository) {
    this.repository = repository;
  }
  
  public DailySummary find(String username, String date) {
    return repository.findByUsernameAndDate(username, date);
  }
  
  public void save(String username, String summary, String date) {
    repository.save(new DailySummary().withUsername(username).withSummary(summary).withDate(date));
  }
  
  public void delete(String username, String date) {
    repository.deleteByUsernameAndDate(username, date);
  }
}
