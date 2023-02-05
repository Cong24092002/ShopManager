package com.startup.ShopManager.controller;

//import com.startup.ShopManager.ServiceImp.UserServiceImp;
import com.startup.ShopManager.DTO.UserDTO;
import com.startup.ShopManager.Service.UserService;
import com.startup.ShopManager.entity.Cart;
import com.startup.ShopManager.entity.User;
import com.startup.ShopManager.entity.UserDeital;
import com.startup.ShopManager.repository.CartRepository;
import com.startup.ShopManager.repository.UserDeitalRepository;
import com.startup.ShopManager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }

//    @GetMapping("")
//    public ResponseEntity<?> getListUser(){
//        List<User> list = userRepository.findAllByEnable("1");
//        return new ResponseEntity<>(list, HttpStatus.OK);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<?> getUserByID(@PathVariable("id") Long id){
//        return new ResponseEntity<>(userRepository.findById(id), HttpStatus.OK);
//    }
//
//    @GetMapping("/findby")
//    public ResponseEntity<?> getUserByUserName(@RequestParam("username") String username){
//        return new ResponseEntity<>(userRepository.findByUsername(username), HttpStatus.OK);
//    }

    @PostMapping("/register")
    public ResponseEntity<?> createNewUser(@RequestBody UserDTO newUser){
        userService.creatUser(newUser);
        return new ResponseEntity<>("Thêm thành công!", HttpStatus.CREATED);
    }

    @PutMapping("/{id}/change-to-password")
    public ResponseEntity<?> updatePassword(@PathVariable("id") Long id,
                                            @RequestParam("new_password") String password){
        userService.changePassword(id,password);
        return new ResponseEntity<>("OK",HttpStatus.OK);
    }

    @PutMapping("/lockup-account") // delete - không xóa hẳn - khóa tạm thời
    public ResponseEntity<?> disableAccount(@RequestParam("id") Long id){
       userService.disableAccount(id);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @GetMapping("/login")
    public String hello(){
        return "Hello người có tiền";
    }


}
