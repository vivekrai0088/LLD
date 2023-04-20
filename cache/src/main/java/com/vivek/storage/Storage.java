package com.vivek.storage;

import com.vivek.exceptions.NotFoundException;
import com.vivek.exceptions.StorageFullException;

public interface Storage<Key, Value> {

  void add(Key key, Value value) throws StorageFullException;

  Value get(Key key) throws NotFoundException;

  void delete(Key key) throws NotFoundException;

}
