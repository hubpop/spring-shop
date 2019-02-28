package com.sh.shop.product;

import org.aspectj.lang.annotation.*;

@Aspect
public class ProductLogger {

    @Pointcut("execution(Product com.sh.shop.product.ProductService.addProduct(..))")
    public void addProduct(){

    }

    @Before("addProduct()")
    public void onStart(){
        System.out.println("Dodajemy produkt");
    }
    @AfterReturning("addProduct()")
    public void onClose(){
        System.out.println("SUCCESS");
    }



}
