package data.repository;

import data.entity.ShoppingCart;
import data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
  ShoppingCart findByUserId(Long userId);
}
