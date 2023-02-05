package com.startup.ShopManager.repository;

import com.startup.ShopManager.entity.Bill;
import com.startup.ShopManager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findById(Long id);
    List<User> findAllByEnable(String enable);
    //List<User> findByUsername(String username);
    Optional<User> findByUsername(String username);
}
