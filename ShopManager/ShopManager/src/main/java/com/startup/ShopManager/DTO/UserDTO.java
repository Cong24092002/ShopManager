package com.startup.ShopManager.DTO;

import com.startup.ShopManager.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String username;
    private String password;

    public UserDTO(User user){
        this.username = user.getUsername();
        this.password = user.getPassword();
    }

}
