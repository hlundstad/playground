package com.lundstad.playground;

import com.lundstad.playground.model.Product;
import feign.Headers;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
//intercontainer communication: containername:eksternal port
//TODO: gjør url dynamisk slik at den kan varieres for mock og product service
//TODO: Kan ShopServiceConfiguration fjernes?
@FeignClient(name = "product-service", url = "http://product-service:8081") //,configuration = ShopServiceConfiguration.class)


public interface ProductClient {
//TODO: SJekk hva som skjer om url endres her og i product-service. Nå matcher de

    @RequestMapping(value = "/products", method = RequestMethod.GET) //Spring Web
    @RequestLine("GET /products")
    public List<Product> getAllProducts();

    @RequestMapping(value = "/productss", method = RequestMethod.GET)
    @RequestLine("GET /productss")
    public String getAllProductss();

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    @RequestLine("GET /product/{id}")
    public Product getProduct(@PathVariable("id") int productId);


    @RequestMapping(value = "/create", method = RequestMethod.PUT)
    @RequestLine("PUT /create")
    @Headers("Content-Type: application/json")
    public void createProduct(Product product);

//    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
//    public ResponseEntity<Product>  updateProduct(@RequestBody Product product);


}
