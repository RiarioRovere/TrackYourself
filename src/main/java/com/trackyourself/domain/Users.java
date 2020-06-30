package com.trackyourself.domain;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
public class Users {
  @Id
  ObjectId _id;
  
  public String username;
  public String password;
}
