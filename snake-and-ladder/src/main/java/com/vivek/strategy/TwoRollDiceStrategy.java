package com.vivek.strategy;

import java.util.Random;

public class TwoRollDiceStrategy implements RollDiceStrategy {
  private Random random = new Random();
  @Override
  public int rollDice() {
    return random.nextInt(6) + 1;
  }
}
