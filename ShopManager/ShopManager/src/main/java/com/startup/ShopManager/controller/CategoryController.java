package com.startup.ShopManager.controller;


import com.startup.ShopManager.DTO.CategoryDTO;
import com.startup.ShopManager.Service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public ResponseEntity<?> getListCategories(){
        return new ResponseEntity<>(categoryService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<?> postCategory(@RequestBody CategoryDTO categoryDTO){
        categoryService.createNewCategory(categoryDTO);
        return new ResponseEntity<>("Thêm thành công!", HttpStatus.CREATED);
    }


}
