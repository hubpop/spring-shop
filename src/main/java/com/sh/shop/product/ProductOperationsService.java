package com.sh.shop.product;

import java.util.List;

public interface ProductOperationsService {

    Product addProduct(Product product);

    Product getProductById(Long id);

    List<Product> getAllProducts();

}
