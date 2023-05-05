package com.vivek.model;

import java.util.List;

public class Game {
  private Player[] players;
  private Board board;
  private Player currentTurn;
  private GameStatus status;
  private List<Move> movesPlayed;

  private void initialize(Player p1, Player p2) {
    players[0] = p1;
    players[1] = p2;

    board.resetBoard();

    if(p1.isWhiteSide()) {
      this.currentTurn = p1;
    } else {
      this.currentTurn = p2;
    }

    movesPlayed.clear();
  }

  public boolean isEnd() {
    return this.status != GameStatus.ACTIVE;
  }

  public void setStatus(GameStatus status) {
    this.status = status;
  }

  public boolean playerMove(Player player, int startX, int startY, int endX, int endY) throws Exception {
    Box startBox = board.getBox(startX, startY);
    Box endBox = board.getBox(endX, endY);

    Move move = new Move(player, startBox, endBox);
    return this.makeMove(move, player);
  }

  private boolean makeMove(Move move, Player player) {
    // TODO
    return true;
  }
}
