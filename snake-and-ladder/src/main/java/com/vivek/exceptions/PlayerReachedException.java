package com.vivek.exceptions;

public class PlayerReachedException extends RuntimeException {
  public PlayerReachedException(String message) {
    super(message);
  }
}
