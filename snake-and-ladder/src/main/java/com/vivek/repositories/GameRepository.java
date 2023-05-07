package com.vivek.repositories;

import com.vivek.models.Game;

public interface GameRepository {

  Game getGame(String gameCode);

  void addGame(Game game);

}
