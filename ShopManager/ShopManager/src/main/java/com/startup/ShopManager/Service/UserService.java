package com.startup.ShopManager.Service;

import com.startup.ShopManager.DTO.UserDTO;
import com.startup.ShopManager.entity.Cart;
import com.startup.ShopManager.entity.User;
import com.startup.ShopManager.entity.UserDeital;
import com.startup.ShopManager.repository.CartRepository;
import com.startup.ShopManager.repository.UserDeitalRepository;
import com.startup.ShopManager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserDeitalRepository userDeitalRepository;
    @Autowired
    private CartRepository cartRepository;
    public UserService(UserRepository userRepository,
                       UserDeitalRepository userDeitalRepository,
                       CartRepository cartRepository){
        this.userRepository = userRepository;
        this.userDeitalRepository = userDeitalRepository;
        this.cartRepository = cartRepository;
    }
    public void creatUser(UserDTO newUser){
        // lưu dữ liệu người dùng đăng kí xuống db
        User user = new User(newUser);
        // khởi tạo trang quản lí khách hàng
        UserDeital userDeital = new UserDeital("","","","","");
        userDeitalRepository.save(userDeital);
        Cart cart = new Cart("0"); // khởi tạo giỏ hàng 0 đồng
        cartRepository.save(cart);
        user.setUserDeital(userDeital); user.setCart(cart);
        userRepository.save(user);
    }
    public void changePassword(Long id, String password){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            User foundUser = userRepository.findById(id).get();
            foundUser.setPassword(password);
            userRepository.save(foundUser);
        }
    }
    public void disableAccount(Long id){
        if(userRepository.findById(id).isPresent()){
            User user = userRepository.findById(id).get();
            user.setEnable("0");
            userRepository.save(user);
        }
    }
    public void enableAccount(Long id){
        if(userRepository.findById(id).isPresent()){
            User user = userRepository.findById(id).get();
            user.setEnable("1");
            userRepository.save(user);
        }
    }
}
