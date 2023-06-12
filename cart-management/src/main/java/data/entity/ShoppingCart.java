package data.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "shopping_carts")
@Data
public class ShoppingCart {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @OneToOne
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToMany
  @JoinTable(
          name = "cart_items",
          joinColumns = @JoinColumn(name = "cart_id"),
          inverseJoinColumns = @JoinColumn(name = "item_id")
  )
  private Set<Item> items;
}

