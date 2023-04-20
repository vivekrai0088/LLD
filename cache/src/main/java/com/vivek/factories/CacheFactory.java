package com.vivek.factories;

import com.vivek.cache.Cache;
import com.vivek.policies.LRUEvictionPolicy;
import com.vivek.storage.HashMapBasedStorage;

public class CacheFactory<Key, Value> {

  public Cache<Key, Value> getDefaultCache(final int capacity) {
    return new Cache<>(new HashMapBasedStorage<Key, Value>(capacity), new LRUEvictionPolicy<Key>());
  }
}
