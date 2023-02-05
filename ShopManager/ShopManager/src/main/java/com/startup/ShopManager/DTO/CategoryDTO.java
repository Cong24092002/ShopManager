package com.startup.ShopManager.DTO;

import com.startup.ShopManager.entity.Category;
import lombok.Data;

@Data
public class CategoryDTO {

    private String type;
    private String comment;

    public CategoryDTO(Category category){
        this.type = category.getType();
        this.comment = category.getComment();
    }
}
