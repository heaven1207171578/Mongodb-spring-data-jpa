package com.bucom.controller;

import lombok.Data;

/**
 * @author HeavenY
 * @date 2019/1/23 12:21
 */
@Data
public class User {
  String id;
  String name;

  public User() {}

  public User(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
