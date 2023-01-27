package com.startup.ShopManager.repository;

import com.startup.ShopManager.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill,Long> {
}
