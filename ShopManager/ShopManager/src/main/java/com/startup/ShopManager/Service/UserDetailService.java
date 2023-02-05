package com.startup.ShopManager.Service;

import com.startup.ShopManager.DTO.UserDetailDTO;
import com.startup.ShopManager.entity.UserDeital;
import com.startup.ShopManager.repository.UserDeitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailService {
    @Autowired
    private UserDeitalRepository userDeitalRepository;

    public UserDetailService(UserDeitalRepository userDeitalRepository){
        this.userDeitalRepository = userDeitalRepository;
    }
    public List<UserDetailDTO> getAll(){
        List<UserDeital> list = userDeitalRepository.findAll();
        List<UserDetailDTO> listDTO = new ArrayList<>();
        for (UserDeital user : list) {
            listDTO.add(new UserDetailDTO(user));
        }
            return listDTO;
    }


}
