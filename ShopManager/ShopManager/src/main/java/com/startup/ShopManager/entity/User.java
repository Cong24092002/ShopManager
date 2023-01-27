package com.startup.ShopManager.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.startup.ShopManager.Enum.Role;
import com.startup.ShopManager.Enum.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "enable")
    private Status enable;
    @Column(name = "role")
    private Role role;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userdeitalid",referencedColumnName = "id")
    @JsonManagedReference
    private UserDeital userDeital;
    @OneToOne
    @JoinColumn(name = "cartid",referencedColumnName = "id")
    @JsonManagedReference
    private Cart cart;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Comment> comments;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Bill> bills;

    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.enable = Status.ENABLE;
        this.role = Role.USER;
    }

}
