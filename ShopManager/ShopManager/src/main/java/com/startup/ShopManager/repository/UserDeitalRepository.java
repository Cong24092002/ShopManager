package com.startup.ShopManager.repository;

import com.startup.ShopManager.entity.Bill;
import com.startup.ShopManager.entity.UserDeital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDeitalRepository extends JpaRepository<UserDeital,Long> {
}
