package com.vivek.services;

import com.vivek.exceptions.GameNotFoundException;
import com.vivek.exceptions.InvalidStateException;
import com.vivek.exceptions.PlayerLimitReachedException;
import com.vivek.managers.MoveManager;
import com.vivek.managers.SnakeAndLadderMoveManager;
import com.vivek.models.Board;
import com.vivek.models.Game;
import com.vivek.models.Player;
import com.vivek.repositories.GameRepository;
import com.vivek.strategy.RollDiceStrategy;

public class SnakeAndLadderGameService implements GameService {
  private GameRepository gameRepository;
  private MoveManager moveManager;
  private RollDiceStrategy rollDiceStrategy;

  public SnakeAndLadderGameService(GameRepository gameRepository, MoveManager moveManager, RollDiceStrategy rollDiceStrategy) {
    this.gameRepository = gameRepository;
    this.moveManager = moveManager;
    this.rollDiceStrategy = rollDiceStrategy;
  }

  public String createGame(Player player, Board board, int maxPlayers) {
    Game game = new Game(board, player, maxPlayers);
    gameRepository.addGame(game);
    return game.getGameCode();
  }

  public boolean joinGame(Player player, String gameCode) {
    if(gameRepository.getGame(gameCode) == null) {
      throw new GameNotFoundException("game not found with gamecode = " + gameCode);
    }
    Game game = gameRepository.getGame(gameCode);
    if(game.getJoinedPlayers().size() == game.getMaxPlayers()) {
      throw new PlayerLimitReachedException("Unable to join the game, players limit reached");
    }

    if(!game.getJoinedPlayers().contains(player)) {
      game.joinPlayer(player);
    }
    return true;
  }

  public void startGame(Player player, String gameCode) {
    if(gameRepository.getGame(gameCode) == null) {
      throw new GameNotFoundException("game not found with gamecode = " + gameCode);
    }
    Game game = gameRepository.getGame(gameCode);
    validateGame(game, player);
    game.start();

    while(true) {
      Player currentPlayer = game.getNextTurnPlayer();
      System.out.println("Current player " + currentPlayer.getName() + " rolling dice");
      int tokens = rollDiceStrategy.rollDice();
      System.out.println("Current player " + currentPlayer.getName() + " get tokens = " + tokens);
      moveManager.makeMove(currentPlayer, game, tokens);
      if(currentPlayer.getTokens() == 100) {
        game.finish();
      }
      if(game.isFinished()) {
        System.out.println("Announce Winner ");
        System.out.println("Player Won = " + currentPlayer.getName());
        break;
      }
    }
  }

  private void validateGame(Game game, Player player) {
    if(game.getJoinedPlayers().size() != game.getMaxPlayers()) {
      throw new InvalidStateException("Game cannot be started until max players joined, current number of players are " + game.getJoinedPlayers().size());
    }
    if(!game.getCreatedByPlayer().equals(player)) {
      throw new InvalidStateException("Game cannot be started by other than player who created the game room");
    }
  }
}
