package com.trackyourself.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
@With
@AllArgsConstructor
@NoArgsConstructor
public class Users {
  @Id
  ObjectId _id;
  
  public String username;
  public String password;
}
