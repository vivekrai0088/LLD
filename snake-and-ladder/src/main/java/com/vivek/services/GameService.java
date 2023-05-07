package com.vivek.services;

import com.vivek.models.Board;
import com.vivek.models.Player;

public interface GameService {
  String createGame(Player player, Board board, int maxPlayers);

  boolean joinGame(Player player, String gameCode);

  void startGame(Player player, String gameCode);
}
