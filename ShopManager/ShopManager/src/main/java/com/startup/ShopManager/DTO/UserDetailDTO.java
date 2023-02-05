package com.startup.ShopManager.DTO;

import com.startup.ShopManager.Enum.Rank;
import com.startup.ShopManager.entity.UserDeital;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailDTO {
    private String fullName;
    private String adress;
    private String email;
    private String phone;
    private String accumulation;
    private Rank rank;

    public UserDetailDTO(UserDeital userDeital){
        this.fullName = userDeital.getFirstName() + " " +userDeital.getLastName();
        this.adress = userDeital.getAdress();
        this.email = userDeital.getEmail();
        this.phone = userDeital.getPhone();
        this.accumulation = userDeital.getAccumulation();
        this.rank = userDeital.getRank();
    }

}
