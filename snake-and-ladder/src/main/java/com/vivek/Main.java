package com.vivek;

import com.vivek.controllers.GameController;
import com.vivek.managers.MoveManager;
import com.vivek.models.Board;
import com.vivek.models.Ladder;
import com.vivek.models.Player;
import com.vivek.models.Snake;
import com.vivek.repositories.GameRepository;
import com.vivek.services.GameService;
import com.vivek.strategy.OneRollDiceStrategy;
import com.vivek.strategy.RollDiceStrategy;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    GameRepository gameRepository = new GameRepository();
    RollDiceStrategy rollDiceStrategy = new OneRollDiceStrategy();
    MoveManager moveManager = new MoveManager();
    GameService gameService = new GameService(gameRepository,moveManager, rollDiceStrategy);
    GameController gameController = new GameController(gameService);


    Player player1 = new Player("Player1");
    Player player2 = new Player("Player2");
    Player player3 = new Player("Player3");
    Player player4 = new Player("Player4");

    List<Snake> snakes = new ArrayList<>();
    snakes.add(new Snake(12, 35));
    List<Ladder> ladders = new ArrayList<>();
    ladders.add(new Ladder(50, 65));
    Board board = new Board(snakes, ladders);

    System.out.println("Player1 is creating game");
    String gameCode = gameController.createGame(player1, board, 4);
    System.out.println("Player1 created game with gameCode = " + gameCode);

    System.out.println("Player2 joining game with gameCode = " + gameCode);
    gameController.joinGame(player2, gameCode);
    System.out.println("Player2 joined game with gameCode = " + gameCode);

    System.out.println("Player3 joining game with gameCode = " + gameCode);
    gameController.joinGame(player3, gameCode);
    System.out.println("Player3 joined game with gameCode = " + gameCode);

    System.out.println("Player4 joining game with gameCode = " + gameCode);
    gameController.joinGame(player4, gameCode);
    System.out.println("Player4 joined game with gameCode = " + gameCode);

    System.out.println("Starting game by player1 with gameCode = " + gameCode);
    gameController.startGame(player1, gameCode);
  }
}