package com.vivek.exceptions;

public class StorageFullException extends RuntimeException {
  public StorageFullException(String message) {
    super(message);
  }
}
