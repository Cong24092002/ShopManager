package com.startup.ShopManager.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.startup.ShopManager.Enum.Rank;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "userdeital")
public class UserDeital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "userid")
    private Long userId;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "adress")
    private String adress;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "accumulation")
    private String accumulation;
    @Column(name = "rank")
    private Rank rank;
    @OneToMany(mappedBy = "userDeital",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Voicher> voichers;
    @OneToOne(mappedBy = "userDeital")
    @JsonBackReference
    private User user;
}
