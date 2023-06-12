package services;

import data.entity.Item;

import java.util.List;

public interface ShoppingCartService {

  List<Item> listItemsOfCart(Long userId);
  boolean addToCart(Long userId, Long itemId);
  boolean removeFromCart(Long userId, Long itemId);

}
