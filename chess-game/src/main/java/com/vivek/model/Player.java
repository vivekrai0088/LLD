package com.vivek.model;

import lombok.Getter;

@Getter

public class Player {
  private boolean white;

  public boolean isWhiteSide() {
    return this.white == true;
  }
}
