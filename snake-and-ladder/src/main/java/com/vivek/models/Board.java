package com.vivek.models;


import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Board {
  private List<Cell> cells;

  public Board(List<Snake> snakes, List<Ladder> ladders) {
    cells = new ArrayList<>();
    for(int i = 0; i < 100; i++) {
      cells.add(new Cell.CellBuilder().
              number(i).
              cellType(CellType.NORMAL).build());
    }

    for(int i = 0; i < snakes.size(); i++) {
      Cell cell = cells.get(snakes.get(i).getStartToken() - 1);
      cell.setSnakeTail(snakes.get(i).getEndToken());
    }

    for(int i = 0; i < ladders.size(); i++) {
      Cell cell = cells.get(ladders.get(i).getStartToken() - 1);
      cell.setLadderTop(ladders.get(i).getEndToken());
    }
  }
}
