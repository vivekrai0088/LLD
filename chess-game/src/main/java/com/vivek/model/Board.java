package com.vivek.model;

public class Board {
  Box[][] boxes;

  public Board() {
    this.resetBoard();
  }

  public void resetBoard() {

  }


  public Box getBox(int startX, int startY) throws Exception {
    if (startX < 0 || startX > 7 || startY < 0 || startY > 7) {
      throw new Exception("Index out of bound");
    }
    return boxes[startX][startY];
  }
}
