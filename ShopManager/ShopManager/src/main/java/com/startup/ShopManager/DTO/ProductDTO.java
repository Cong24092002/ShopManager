package com.startup.ShopManager.DTO;

import com.startup.ShopManager.entity.Image;
import com.startup.ShopManager.entity.Product;
import lombok.Data;

import java.util.Set;

@Data
public class ProductDTO {
    private String productName;
    private String price;
    private String introduce;
    private Long vote;
    private String discount;

    private Set<Image> images;
    public ProductDTO(Product product){
        this.productName = product.getProductName();
        this.introduce = product.getIntroduce();
        this.vote = product.getVote();
        this.discount = product.getDiscount();
        //giá bán = giá nhập x 110%
        //this.price = String.valueOf(Long.parseLong(product.getCount()) * 1.1 );
        this.price = product.getCount();
        this.images = product.getImages();
    }
}
