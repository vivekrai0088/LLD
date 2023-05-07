package com.vivek.managers;

import com.vivek.models.Cell;
import com.vivek.models.CellType;
import com.vivek.models.Game;
import com.vivek.models.Player;


public class SnakeAndLadderMoveManager implements MoveManager {

  public void makeMove(Player currentPlayer, Game game, int tokens) {
    int destinationToken = currentPlayer.getTokens() + tokens;
    if(destinationToken > 100) {
      game.movePlayerTurn();
      return;
    }

    System.out.println("target tokens = " + destinationToken);
    Cell cell = game.getBoard().getCells().get(destinationToken - 1);
    if(cell.getCellType().equals(CellType.NORMAL)) {
      game.movePlayerTurn();
    }
    else if(cell.getCellType().equals(CellType.SNAKE_HEAD)) {
      destinationToken = cell.getSnakeTail();
      System.out.println("Found Snake head, updated target tokens = " + destinationToken);
      game.movePlayerTurn();
    }
    else if(cell.getCellType().equals(CellType.LADDER_HEAD)) {
      destinationToken = cell.getLadderTop();
      System.out.println("Found ladder head, updated target tokens = " + destinationToken);
      game.movePlayerTurn();
    }
    else if(cell.getCellType().equals(CellType.SPECIAL_LADDER_HEAD)) {
      destinationToken = cell.getLadderTop();
      System.out.println("Found special snake head, updated target tokens = " + destinationToken);
    }
    currentPlayer.updateToken(destinationToken);
  }

}
