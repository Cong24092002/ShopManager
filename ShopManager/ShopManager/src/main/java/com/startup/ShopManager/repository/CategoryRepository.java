package com.startup.ShopManager.repository;

import com.startup.ShopManager.entity.Bill;
import com.startup.ShopManager.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
