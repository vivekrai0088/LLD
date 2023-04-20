package com.vivek;

import com.vivek.cache.Cache;
import com.vivek.policies.LRUEvictionPolicy;
import com.vivek.storage.HashMapBasedStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CacheTest {
  Cache<Integer, Integer> cache;

  @BeforeEach
  public void setUp() {
    cache = new Cache<>(new HashMapBasedStorage<Integer, Integer>(3), new LRUEvictionPolicy<Integer>());
  }

  @Test
  public void testCache() {
    cache.set(1, 1);
    assertEquals(1, cache.get(1));
  }

}
