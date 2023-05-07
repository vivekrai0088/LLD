package com.vivek.repositories;

import com.vivek.models.Game;

import java.util.HashMap;
import java.util.Map;

public class InMemoryGameRepository implements GameRepository {
  private Map<String, Game> games;

  public InMemoryGameRepository() {
    games = new HashMap<>();
  }

  public Game getGame(String gameCode) {
    return games.get(gameCode);
  }

  public void addGame(Game game) {
    games.put(game.getGameCode(), game);
  }
}
