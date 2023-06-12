package services;

import data.entity.CartItem;
import data.entity.Item;
import data.entity.ShoppingCart;
import data.entity.User;
import data.entity.UserStatus;
import data.repository.ItemRepository;
import data.repository.ShoppingCartRepository;
import data.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService {

  private UserRepository userRepository;
  private ItemRepository itemRepository;
  private ShoppingCartRepository shoppingCartRepository;

  public List<Item> listItemsOfCart(Long userId) {
    ShoppingCart shoppingCart = shoppingCartRepository.findByUserId(userId);
    if(shoppingCart == null) return new ArrayList<Item>();
    return new ArrayList<Item>(shoppingCart.getItems());
  }

  public boolean addToCart(Long userId, Long itemId) {
    User user = userRepository.getById(userId);
    Item item = itemRepository.getById(itemId);
    if(user == null || item == null || !user.getStatus().equals(UserStatus.SUSPENDED)) {
      return false;
    }
    if(item.getStock() == 0) return false;

    ShoppingCart shoppingCart = shoppingCartRepository.findByUserId(userId);
    if(shoppingCart == null) {
      shoppingCart = new ShoppingCart();
      shoppingCart.setItems(new HashSet<Item>(Arrays.asList(item)));
    } else {
      Set<Item> items = shoppingCart.getItems();
      items.add(item);
    }
    shoppingCartRepository.save(shoppingCart);
    return true;
  }

  public boolean removeFromCart(Long userId, Long itemId) {
    User user = userRepository.getById(userId);
    Item item = itemRepository.getById(itemId);

    if(user == null || item == null) {
      return false;
    }

    ShoppingCart shoppingCart = shoppingCartRepository.findByUserId(userId);
    if(shoppingCart == null) throw new RuntimeException("trying to remove from cart which doesn't exists");

    Set<Item> items = shoppingCart.getItems();
    items.remove(item);
    shoppingCartRepository.save(shoppingCart);
    return true;
  }
}
