package com.vivek.models;

import java.util.Random;

public class Dice {
  private Random random = new Random(System.currentTimeMillis());

  public int rollDice() {
    return random.nextInt(6) + 1;
  }
}
