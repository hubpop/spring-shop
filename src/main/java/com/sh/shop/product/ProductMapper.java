package com.sh.shop.product;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product map(ProductTO productTO);
    ProductTO map(Product product);

//    @IterableMapping(elementTargetType = ProductTO.class)
//    List<ProductTO> map(List<Product> products);

}
