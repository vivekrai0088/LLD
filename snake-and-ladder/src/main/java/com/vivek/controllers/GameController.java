package com.vivek.controllers;

import com.vivek.models.Board;
import com.vivek.models.Player;
import com.vivek.services.GameService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GameController {

  private final GameService gameService;

  public String createGame(Player player, Board board, int maxPlayers) {
    String gameCode = gameService.createGame(player, board, maxPlayers);
    return gameCode;
  }

  public boolean joinGame(Player player, String gameCode) {
    return gameService.joinGame(player, gameCode);
  }

  public void startGame(Player player, String gameCode) {
    gameService.startGame(player, gameCode);
  }
}
