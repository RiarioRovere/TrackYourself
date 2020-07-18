package com.trackyourself.domain;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import org.bson.types.ObjectId;

@Data
@With
@AllArgsConstructor
@NoArgsConstructor
public class Signal {
  @Id
  private ObjectId id;
  
  private String username;
  private String name;
  private double value;
  private String date;
}
