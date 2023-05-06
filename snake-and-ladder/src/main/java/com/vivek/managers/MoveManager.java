package com.vivek.managers;

import com.vivek.models.Cell;
import com.vivek.models.CellType;
import com.vivek.models.Game;
import com.vivek.models.Player;

import java.util.List;


public class MoveManager {

  public void makeMove(Player currentPlayer, Game game, int tokens) {
    int targetTokens = Math.min(100, currentPlayer.getTokens() + tokens);
    System.out.println("target tokens = " + targetTokens);
    Cell cell = game.getBoard().getCells().get(targetTokens - 1);
    if(cell.getCellType().equals(CellType.SNAKE_HEAD)) {
      targetTokens = cell.getSnakeTail();
      System.out.println("Found Snake head, updated target tokens = " + targetTokens);
    }
    if(cell.getCellType().equals(CellType.LADDER_HEAD)) {
      targetTokens = cell.getLadderTop();
      System.out.println("Found ladder head, updated target tokens = " + targetTokens);
    }
    currentPlayer.updateToken(targetTokens);

    List<Player> joinedPlayers = game.getJoinedPlayers();
    int index = joinedPlayers.indexOf(currentPlayer);
    int nextIndex = (index + 1) % game.getMaxPlayers();
    game.setCurrentPlayerTurn(game.getJoinedPlayers().get(nextIndex));
  }

}
