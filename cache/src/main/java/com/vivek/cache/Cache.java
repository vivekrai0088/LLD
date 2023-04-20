package com.vivek.cache;

import com.vivek.exceptions.NotFoundException;
import com.vivek.exceptions.StorageFullException;
import com.vivek.policies.EvictionPolicy;
import com.vivek.storage.Storage;

public class Cache<Key, Value> {
  private final Storage<Key, Value> storage;
  private final EvictionPolicy<Key> evictionPolicy;

  public Cache(Storage<Key, Value> storage, EvictionPolicy<Key> evictionPolicy) {
    this.storage = storage;
    this.evictionPolicy = evictionPolicy;
  }

  public void set(Key key, Value value) {
    try {
      storage.add(key, value);
      evictionPolicy.keyAccessed(key);
    } catch (StorageFullException exception) {
      System.out.println("Storage full, trying to evict");
      Key evictedKey = evictionPolicy.evictKey();
      if(evictedKey == null) {
        throw new RuntimeException("Unexpected state, storage is full but no key found to evict");
      }
      storage.delete(evictedKey);
      System.out.println("Creating space by evicting item..." + key);
      storage.add(key, value);
    }
  }

  public Value get(Key key) {
    try {
      Value value = storage.get(key);
      evictionPolicy.keyAccessed(key);
      return value;
    } catch (NotFoundException notFoundException) {
      System.out.println("Tried to access non-existing key.");
      return null;
    }
  }
}
