package com.startup.ShopManager.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "voicher")
public class Voicher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "voichername")
    private String voicherName;
    @Column(name = "reductionrate")
    private String reductionRate; // phần trăm giảm
    @Column(name = "reductionprice")
    private String reductionPrice; // giảm trực tiếp vào tiền
    @ManyToOne
    @JoinColumn(name = "userdeitalid", referencedColumnName = "id")
    @JsonBackReference
    private UserDeital userDeital;
}
