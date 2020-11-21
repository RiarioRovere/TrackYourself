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
public class Goal {
  @Id
  private String id;
  
  private String username;
  private String title;
  private String description;
  private Date date;
}
