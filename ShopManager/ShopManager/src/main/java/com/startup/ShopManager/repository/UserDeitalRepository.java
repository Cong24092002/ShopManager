package com.startup.ShopManager.repository;

import com.startup.ShopManager.entity.Bill;
import com.startup.ShopManager.entity.UserDeital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDeitalRepository extends JpaRepository<UserDeital,Long> {
}
