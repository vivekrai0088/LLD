package com.vivek.models;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class Game {
  private String gameCode;
  private List<Player> joinedPlayers;
  private Player createdByPlayer;
  private GameStatus gameStatus;
  private Board board;
  private Player currentPlayerTurn;
  private int maxPlayers;

  public Game(Board board, Player player, int maxPlayers) {
    this.createdByPlayer = player;
    this.joinedPlayers = new ArrayList<>();
    this.joinedPlayers.add(player);
    this.gameCode = UUID.randomUUID().toString();
    this.board = board;
    this.currentPlayerTurn = player;
    this.maxPlayers = maxPlayers;
  }

  public void setCurrentPlayerTurn(Player currentPlayerTurn) {
      this.currentPlayerTurn = currentPlayerTurn;
  }

  public void joinPlayer(Player player) {
    joinedPlayers.add(player);
  }

  public void resetPlayersToken() {
    for(int i = 0; i < joinedPlayers.size(); i++) {
      System.out.println("Resetting token for player = " + joinedPlayers.get(i).getName());
      joinedPlayers.get(i).resetToken();
    }
  }

  public void start() {
    gameStatus = GameStatus.IN_PROGRESS;
  }

  public void finish() {
    gameStatus = GameStatus.FINISHED;
  }

  public boolean isFinished() {
    return gameStatus.equals(GameStatus.FINISHED);
  }
}
