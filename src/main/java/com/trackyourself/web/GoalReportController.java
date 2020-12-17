package com.trackyourself.web;

import java.security.Principal;
import java.util.List;

import com.trackyourself.dao.GoalReportDAO;
import com.trackyourself.domain.GoalReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class GoalReportController {
  private GoalReportDAO reportDAO;
  
  @Autowired
  public GoalReportController(GoalReportDAO reportDAO) {
    this.reportDAO = reportDAO;
  }
  
  @GetMapping("/goal/{id}/reports")
  public List<GoalReport> getGoalReports(@PathVariable String id) {
    return reportDAO.findGoalReportByGoalId(id);
  }
  
  @PostMapping("/goal/{id}/report")
  public void saveGoalReport(@RequestBody GoalReport report, @PathVariable String id, Principal principal) {
    reportDAO.save(report.withGoalId(id), principal.getName());
  }
  
  @GetMapping("/goal/report/{reportId}")
  public GoalReport getReport(@PathVariable String reportId) {
    return reportDAO.findById(reportId);
  }
  
  @DeleteMapping("/goal/report/{reportId}")
  public void deleteReport(@PathVariable String reportId, Principal principal) {
    reportDAO.deleteByIdAndUsername(reportId, principal.getName());
  }
}
