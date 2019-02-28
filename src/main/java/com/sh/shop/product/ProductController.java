package com.sh.shop.product;

import com.sh.shop.utils.UriBuilder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RequestMapping("/api/v1/products")
@RestController
@RequiredArgsConstructor
public class ProductController {

    @NonNull
    ProductService productService;

    @NonNull
    ProductMapper productMapper;

    UriBuilder uriBuilder = new UriBuilder();


    public ProductTO getProduct(){
        return null;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createProduct(@RequestBody @Valid ProductTO productTO, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().build();
        }
        Product product = productMapper.map(productTO);

        productService.addProduct(product);
        URI uri = uriBuilder.requestUriWithId(product.getId());
        return ResponseEntity.created(uri).build();
    }


    @RequestMapping(method = RequestMethod.GET,value = "{id}")
    public ProductTO getProduct(@PathVariable("id") Long id){
        Product product = productService.getProductById(id);

        return productMapper.map(product);
    }

}
