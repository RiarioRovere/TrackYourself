package com.trackyourself.domain;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import org.bson.types.ObjectId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@With
public class DailySummary {
  @Id
  ObjectId id;
  
  private String username;
  private String summary;
  private String date;
}
