package com.sh.shop.product;

import com.sh.shop.product.Product;
import com.sh.shop.product.ProductRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@DataJpaTest
@RunWith(SpringRunner.class)
public class ProductRepositoryTest {

    private static final Long PRICE = 1_000L;

    private static final String NAME = "Rowerek";

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TestEntityManager testEntityManager;
    private Product product = new Product();

    @Before
    public void setUp(){
        product.setName(NAME);
        product.setPrice(PRICE);
        testEntityManager.persist(product);
        testEntityManager.flush();
    }


    @Test
    public void shouldReturnProductWithExpectedNameAndPrice(){
        Product tempProduct = productRepository.getByNameAndPrice(NAME,PRICE);

        assertEquals(product.getName(),tempProduct.getName());
    }

}
