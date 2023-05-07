package com.vivek.models;

import lombok.Getter;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.UUID;

@Getter
public class Game {
  private String gameCode;
  private Queue<Player> joinedPlayers;
  private Player createdByPlayer;
  private GameStatus gameStatus;
  private Board board;
  private Player nextTurnPlayer;
  private int maxPlayers;

  public Game(Board board, Player player, int maxPlayers) {
    this.createdByPlayer = player;
    this.joinedPlayers = new ArrayDeque<>();
    this.joinedPlayers.add(player);
    this.gameCode = UUID.randomUUID().toString();
    this.board = board;
    this.nextTurnPlayer = player;
    this.maxPlayers = maxPlayers;
  }

  public void movePlayerTurn() {
      Player player = joinedPlayers.peek();
      joinedPlayers.poll();
      joinedPlayers.add(player);
  }

  public Player getNextTurnPlayer() {
    return joinedPlayers.peek();
  }

  public void joinPlayer(Player player) {
    joinedPlayers.add(player);
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
