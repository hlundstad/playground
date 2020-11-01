package com.lundstad.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(scanBasePackages={
        "com.lundstad.products"})
@EnableDiscoveryClient
//@ComponentScan("com.lundstad.products")
@Configuration
public class ProductServiceApplication{ //extends ResourceConfig {

//    public ProductServiceApplication() {
//        register(ProductController.class);
//    }

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Bean
    public ProductService productService() {
        return new ProductServiceImpl();
    }
}
