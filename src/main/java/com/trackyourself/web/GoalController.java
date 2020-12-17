package com.trackyourself.web;

import java.security.Principal;
import java.util.List;

import com.trackyourself.dao.GoalDAO;
import com.trackyourself.domain.Goal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoalController {
  private GoalDAO goalDAO;
  
  @Autowired
  public GoalController(GoalDAO goalDAO) {
    this.goalDAO = goalDAO;
  }
  
  @GetMapping("/goals")
  public List<Goal> getGoals(@RequestParam(required = false) String user, Principal principal) {
    if (user == null) {
      return goalDAO.findGoalByUsername(principal.getName());
    } else {
      return goalDAO.findGoalByUsername(user);
    }
  }
  
  @PostMapping("/goal")
  public void saveGoal(@RequestBody Goal goal, Principal principal) {
    goalDAO.save(goal, principal.getName());
  }
  
  @GetMapping("/goal/{id}")
  public Goal getGoal(@PathVariable String id) {
    return goalDAO.findById(id);
  }
  
  @DeleteMapping("/goal/{id}")
  public void deleteGoal(@PathVariable String id) {
    goalDAO.deleteById(id);
  }
}
