package com.startup.ShopManager.controller;

import com.startup.ShopManager.DTO.ProductDTO;
import com.startup.ShopManager.Service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping("")
    public ResponseEntity<?> getProducts(){
        return new ResponseEntity<>(productService.getListPro(), HttpStatus.OK);
    }
//    public ResponseEntity<?> postNewProduct(@RequestBody ProductDTO productDTO,
//                                            MultipartFile file){
//        return new ResponseEntity<>("Thêm thành công!", HttpStatus.CREATED);
//    }

}
