package com.startup.ShopManager.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.cloudinary.*;

@Configuration
public class CloudynaryConfig {

    @Bean
    public Cloudinary cloudinary(){
        Cloudinary c = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dxlgrtrvr",
                "api_key", "739979657735999",
                "api_secret", "55fdBa8UfDDI5YlECplB9u03HR0",
                "secure", true
        ));
        return c;
    }


}
