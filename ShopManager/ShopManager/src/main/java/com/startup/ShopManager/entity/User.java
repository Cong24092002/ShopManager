package com.startup.ShopManager.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.startup.ShopManager.DTO.UserDTO;
import com.startup.ShopManager.Enum.Role;
import com.startup.ShopManager.Enum.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "enable")
    private String enable;
    @Column(name = "role")
    private String role;
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
        this.enable = "1";
        this.role = "USER";
    }
    public  User(UserDTO userDTO){
        this.username = userDTO.getUsername();
        this.password = userDTO.getPassword();
        this.enable = "1";
        this.role = "USER";
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
