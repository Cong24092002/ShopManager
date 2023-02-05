package com.startup.ShopManager.controller;


import com.startup.ShopManager.DTO.UserDetailDTO;
import com.startup.ShopManager.Service.UserDetailService;
import com.startup.ShopManager.entity.UserDeital;
import com.startup.ShopManager.repository.UserDeitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/userdetail")
public class UserDetailController {

    private UserDetailService userDetailService;
    public UserDetailController(UserDetailService userDetailService){
        this.userDetailService = userDetailService;
    }
    @GetMapping("/get-all")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(userDetailService.getAll(), HttpStatus.OK);
    }
}
