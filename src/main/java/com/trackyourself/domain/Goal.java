package com.trackyourself.domain;

import java.util.Date;

import javax.persistence.Id;

import lombok.*;

@Data
@With
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Goal {
  @Id
  private String id;
  
  private String username;
  private String title;
  private String description;
  private Boolean isPublic;
  private Date date;

  public Goal mergeFrom(Goal o) {
    if (this == o) return this;
    GoalBuilder b = this.toBuilder();
    if (o.title != null) {
      b.title = o.title;
    }
    if (o.description != null) {
      b.description = o.description;
    }
    if (o.isPublic != null) {
      b.isPublic = o.isPublic;
    }
    if (o.date != null) {
      b.date = o.date;
    }
    return b.build();
  }
}
