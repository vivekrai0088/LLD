package com.vivek.models;

import lombok.Getter;


@Getter
public class Player {

  private String name;
  private int tokens;

  public Player(String name) {
    this.name = name;
    this.tokens = 1;
  }

  public void updateToken(int tokens) {
    this.tokens = tokens;
  }

  public void resetToken() {
    this.tokens = 1;
  }
}
