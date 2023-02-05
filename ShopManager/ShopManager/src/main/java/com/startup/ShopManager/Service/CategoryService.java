package com.startup.ShopManager.Service;

import com.startup.ShopManager.DTO.CategoryDTO;
import com.startup.ShopManager.entity.Category;
import com.startup.ShopManager.entity.Product;
import com.startup.ShopManager.repository.CategoryRepository;
import com.startup.ShopManager.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    public CategoryService(CategoryRepository categoryRepository,
                            ProductRepository productRepository){
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }
    public List<CategoryDTO> getAll(){
        List<CategoryDTO> list = new ArrayList<>();
        List<Category> c = categoryRepository.findAll();
        for (Category category : c) {
            list.add(new CategoryDTO(category));
        }
        return list;
    }
    public void createNewCategory(CategoryDTO categoryDTO){
        Category category = new Category();
        category.setType(categoryDTO.getType());
        category.setComment(categoryDTO.getComment());
        categoryRepository.save(category);
    }
}
