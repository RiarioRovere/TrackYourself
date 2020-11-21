package com.trackyourself.domain;

import java.util.Date;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@Data
@With
@AllArgsConstructor
@NoArgsConstructor
public class GoalReport {
  @Id
  private String id;
  private String goalId;
  private String username;
  private Date date;
  
  private String content;
}
