package com.vivek.storage;

import com.vivek.exceptions.NotFoundException;
import com.vivek.exceptions.StorageFullException;

import java.util.HashMap;
import java.util.Map;

public class HashMapBasedStorage<Key, Value> implements Storage<Key, Value> {

  private Map<Key, Value> storage;
  private final Integer capacity;

  public HashMapBasedStorage(Integer capacity) {
    this.capacity = capacity;
    storage = new HashMap<>();
  }

  public void add(Key key, Value value) throws StorageFullException {
    if(isStorageFull()) throw new StorageFullException("Storage full");
    storage.put(key, value);
  }

  public Value get(Key key) throws NotFoundException {
    if(!storage.containsKey(key)) throw new NotFoundException(key + "doesn't exist in cache.");
    return storage.get(key);
  }

  public void delete(Key key) throws NotFoundException {
    if (!storage.containsKey(key)) throw new NotFoundException(key + "doesn't exist in cache.");
    storage.remove(key);
  }

  private boolean isStorageFull() {
    return storage.size() == capacity;
  }
}
