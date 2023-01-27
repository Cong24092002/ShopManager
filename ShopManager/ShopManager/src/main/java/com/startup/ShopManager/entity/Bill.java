package com.startup.ShopManager.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.startup.ShopManager.Enum.Status;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "date")
    private Date date; // ngày xuất hóa đơn
    @Column(name = "total")
    private String total;
    @Column(name = "status")
    private Status status; // cho biết đã thanh toán hay chưa 0-chưa 1-OK
    @OneToMany(mappedBy = "bill",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Product> products;
    @ManyToOne
    @JoinColumn(name = "userid",referencedColumnName = "id")
    @JsonBackReference
    private User user;
}
