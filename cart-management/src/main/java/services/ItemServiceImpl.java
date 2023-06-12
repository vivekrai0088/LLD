package services;

import data.entity.Item;
import data.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
  private ItemRepository itemRepository;

  public boolean addItem(String name, double price, int stock) {
    Item item = Item.builder().name(name).price(price).stock(stock).build();
    itemRepository.save(item);
    return true;
  }
}
