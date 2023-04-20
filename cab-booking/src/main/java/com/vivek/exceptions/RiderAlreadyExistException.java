package com.vivek.exceptions;

public class RiderAlreadyExistException extends RuntimeException {
  public RiderAlreadyExistException(String message) {
    super(message);
  }
}
