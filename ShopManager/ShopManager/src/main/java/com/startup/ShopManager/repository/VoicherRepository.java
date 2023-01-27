package com.startup.ShopManager.repository;

import com.startup.ShopManager.entity.Bill;
import com.startup.ShopManager.entity.Voicher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoicherRepository extends JpaRepository<Voicher,Long> {
}
