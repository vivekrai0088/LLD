package com.vivek;

import com.vivek.cache.Cache;
import com.vivek.factories.CacheFactory;

public class Main {
  public static void main(String[] args) {
    CacheFactory<String, String> cacheFactory = new CacheFactory<>();
    Cache<String, String> cache = cacheFactory.getDefaultCache(100);
    cache.set("name", "vivek");
    cache.set("age", "28");

    System.out.println(cache.get("name"));
    System.out.println(cache.get("age"));
  }
}
