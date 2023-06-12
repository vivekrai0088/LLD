package data.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "cart_items")
@Data
public class CartItem {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "cart_id")
  private ShoppingCart cart;

  @ManyToOne
  @JoinColumn(name = "item_id")
  private Item item;
}

