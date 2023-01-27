package com.startup.ShopManager.repository;

import com.startup.ShopManager.entity.Bill;
import com.startup.ShopManager.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {
}
