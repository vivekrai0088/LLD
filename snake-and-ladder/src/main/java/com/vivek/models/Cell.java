package com.vivek.models;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Cell {
  private int number;
  private CellType cellType;

  private int snakeTail;
  private int ladderTop;

  public void setSnakeTail(int endToken) {
    this.cellType = CellType.SNAKE_HEAD;
    snakeTail = endToken;
  }

  public void setLadderTop(int endToken) {
    this.cellType = CellType.LADDER_HEAD;
    ladderTop = endToken;
  }


}
