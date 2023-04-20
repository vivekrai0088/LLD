package com.vivek.exceptions;

public class CabNotExistsException extends RuntimeException {
  public CabNotExistsException(String message) {
    super(message);
  }
}
