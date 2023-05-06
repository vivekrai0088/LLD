package com.vivek.repositories;

import com.vivek.models.Game;

import java.util.HashMap;
import java.util.Map;

public class GameRepository {
  private Map<String, Game> games;

  public GameRepository() {
    games = new HashMap<>();
  }

  public Game getGame(String gameCode) {
    return games.get(gameCode);
  }

  public void addGame(Game game) {
    games.put(game.getGameCode(), game);
  }
}
