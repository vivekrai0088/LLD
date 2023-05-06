package com.vivek.exceptions;

public class PlayerLimitReachedException extends RuntimeException {
  public PlayerLimitReachedException(String message) {
    super(message);
  }
}
