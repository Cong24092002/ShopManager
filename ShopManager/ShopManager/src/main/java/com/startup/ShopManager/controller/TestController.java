package com.startup.ShopManager.controller;

import com.startup.ShopManager.entity.Cart;
import com.startup.ShopManager.entity.Product;
import com.startup.ShopManager.entity.User;
import com.startup.ShopManager.repository.CartRepository;
import com.startup.ShopManager.repository.ProductRepository;
import com.startup.ShopManager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class TestController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CartRepository cartRepository;
    List<Product> products = new ArrayList<>();
    @GetMapping("/creatuser")
    public void testV1(){
        Cart c1 = new Cart();
        User u1 = new User("congmn17","12345");
        User u2 = new User("hiepvh8","54321");

        //userRepository.save(u1);// userRepository.save(u2);
        Product p1 = new Product("coca", LocalDate.now(),"1000","ngon-bổ-rẻ");
        Product p2 = new Product("maybach", LocalDate.now(),"2","sang-sịn-mịn");
        productRepository.save(p1); productRepository.save(p2);
        products.add(p1); products.add(p2);
        c1.setProducts(products); cartRepository.save(c1);
        u1.setCart(c1);
        userRepository.save(u1);


    }

    @GetMapping("/test")
    public void testV2(){
        //Optional<User> u = userRepository.findById(2L);
        User u2 = new User("hiepvh8","54321");
        Product p2 = new Product("maybach", LocalDate.now(),"2","sang-sịn-mịn");
        Cart c = new Cart();
        products.clear();
        products.add(p2);
        c.setProducts(products); cartRepository.save(c);
        u2.setCart(c); userRepository.save(u2);

    }

}
