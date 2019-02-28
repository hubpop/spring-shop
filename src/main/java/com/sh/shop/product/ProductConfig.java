package com.sh.shop.product;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {

    @Bean
    public ProductLogger productLogger(){
        return new ProductLogger();
    }

}
