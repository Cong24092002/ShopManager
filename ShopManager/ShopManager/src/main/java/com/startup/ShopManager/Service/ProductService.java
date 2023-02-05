package com.startup.ShopManager.Service;

import com.startup.ShopManager.DTO.ProductDTO;
import com.startup.ShopManager.entity.Product;
import com.startup.ShopManager.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<ProductDTO> getListPro(){
        List<ProductDTO> listDTO = new ArrayList<>();
        List<Product> products = productRepository.findAll();
        for (Product p : products) {
            listDTO.add(new ProductDTO(p));
        }
        return listDTO;
    }
    public void createNewProduct(ProductDTO productDTO, MultipartFile file){
        Product p = new Product(productDTO);
        productRepository.save(p);
    }
}
