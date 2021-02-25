package com.lundstad.playground.api.v1;

import com.lundstad.playground.EmployeeClient;
import com.lundstad.playground.ProductClient;
import com.lundstad.playground.model.Employee;
import com.lundstad.playground.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    ProductClient productClient;
    @Autowired
    EmployeeClient employeeClient;

    @GetMapping("/fetchProducts")
    public String  getAllProducts() {
        return ResponseEntity.ok(productClient.getAllProducts()).toString();
    }

    @GetMapping("/fetchEmployees")
    public String  getAllEmployees() {
        return ResponseEntity.ok(employeeClient.getAllEmployees()).toString();
    }


    @PostMapping("/createemployees")
    public  @ResponseBody Employee createEmployees( @RequestBody Employee employee) {
        return employeeClient.createEmployee(employee);
    }

    @GetMapping("/fetchProduct/{id}")
    public ResponseEntity<Product> fetchProduct(@PathVariable int id) {
        return ResponseEntity.ok(productClient.getProduct(id));
    }



}