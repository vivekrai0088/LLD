package com.vivek.managers;

import com.vivek.models.Game;
import com.vivek.models.Player;

public interface MoveManager {
  void makeMove(Player currentPlayer, Game game, int tokens);
}
