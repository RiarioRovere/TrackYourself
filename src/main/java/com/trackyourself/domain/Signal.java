package com.trackyourself.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@Entity
@Data
@With
@AllArgsConstructor
@NoArgsConstructor
public class Signal {
  @Id
  @GeneratedValue
  private long id;
  
  private String username;
  private String name;
  private double value;
}
