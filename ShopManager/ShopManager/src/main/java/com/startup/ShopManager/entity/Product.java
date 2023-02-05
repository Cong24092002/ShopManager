package com.startup.ShopManager.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.startup.ShopManager.DTO.ProductDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "productname")
    private String productName;
    @Column(name = "firstday")
    private LocalDate firstDate; // ngày nhập
    @Column(name = "count")
    private String count; // giá nhập
    @Column(name = "introduce")
    private String introduce; // giới thiệu
    @Column(name = "vote")
    private Long vote;
    //private String comment;
    @Column(name = "discount")
    private String discount; // giảm giá
    @ManyToMany(mappedBy = "products")
    @JsonBackReference
    private Set<Cart> cart; // không cho trùng giỏ hàng
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Comment> comments;
    @ManyToOne
    @JoinColumn(name = "categoryid", referencedColumnName = "id")
    @JsonBackReference
    private Category category;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Image> images;

    @ManyToOne
    @JoinColumn(name = "billid", referencedColumnName = "id")
    @JsonBackReference
    private Bill bill;

    public Product(String productName,LocalDate firstDate,String count,String introduce){
        this.productName = productName;
        this.firstDate = firstDate;
        this.count = count;
        this.introduce = introduce;
    }
    public Product(ProductDTO productDTO){
        this.productName = productDTO.getProductName();
        this.firstDate = LocalDate.now();
        this.count = productDTO.getPrice();
        this.introduce = productDTO.getIntroduce();
    }


}
