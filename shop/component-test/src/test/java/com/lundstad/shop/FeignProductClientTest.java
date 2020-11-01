package com.lundstad.shop;

import com.lundstad.playground.ProductClient;
import com.lundstad.playground.ProductControllerFeignClientBuilder;
import com.lundstad.playground.model.Product;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class FeignProductClientTest extends AbstractShopTest {
    private ProductClient productClient;

    @Before
    public void setup() {
        ProductControllerFeignClientBuilder feignClientBuilder = new ProductControllerFeignClientBuilder(PRODUCT_SERVICE_URL);
        productClient = feignClientBuilder.getProductClient();
    }


    @Test
    public void getAllProducts() throws Exception {
        List<Product> products = new ArrayList<>(productClient.getAllProducts());
        assertTrue(products.size() >= 3);
    }


    @Test
    public void createOneProduct() throws Exception {
        int preCount = new ArrayList<>(productClient.getAllProducts()).size();
        productClient.createProduct(new Product(null,"Strawberries",20D));
        int postCount = new ArrayList<>(productClient.getAllProducts()).size();
        assertTrue( postCount == (preCount+1));
    }
}
