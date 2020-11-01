package com.lundstad.products;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
//@Component
public class ProductServiceImpl implements ProductService {
    private static final Map<Integer, Product> productRepo = new HashMap<>();
    private static int i=0;

    static {
//        Product honey = new Product(1,"Honey",20);
//        productRepo.put(honey.getId(), honey);
//        Product coffee = new Product(2,"Coffe",10);
//        productRepo.put(coffee.getId(), coffee);
//        Product tea = new Product(3,"Tea",30);
//        productRepo.put(tea.getId(), tea);
        setupRepo();

    }
    public static void setupRepo(){
        Product honey = new Product(++i,"Honey",20D);
        productRepo.put(honey.getId(), honey);
        Product coffee = new Product(++i,"Coffe",10D);
        productRepo.put(coffee.getId(), coffee);
        Product tea = new Product(++i,"Tea",30D);
        productRepo.put(tea.getId(), tea);

    }

    @Override
    public void createProduct(Product product) {
        System.out.println(i);
        product.setId(++i);
        productRepo.put(product.getId(), product);
    }
    @Override
    public void updateProduct(int id, Product tempProduct) {
        Product p = productRepo.get(id);
        p.setName(tempProduct.getName()!=null? tempProduct.getName() : p.getName());
        p.setPrice(tempProduct.getPrice()!=null? tempProduct.getPrice() : p.getPrice());
    }
    @Override
    public void deleteProduct(int id) {
        System.out.println("sletter: "+ id);
        productRepo.remove(id);

    }
    @Override
    public Collection<Product> getProducts() {
        System.out.println("Products in Service: "+ productRepo.size());
        return productRepo.values();
    }

    @Override
    public Product getProduct(int id) {
        return productRepo.get(id);
    }


}
