package com.lundstad.playground.api.v1;

import com.lundstad.playground.ProductClient;
import com.lundstad.playground.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import javax.ws.rs.GET;
//import javax.ws.rs.Path;


//@OpenAPIDefinition(info = Info)
//@Produces(MediaType.APPLICATION_JSON)
@RestController
public class ProductController {


    @Autowired
    ProductClient productClient;

    @GetMapping("/fetchProducts")
    public String  getAllProducts() {
        return ResponseEntity.ok(productClient.getAllProducts()).toString();
    }


    @GetMapping("/fetchProductss")
    public String  getAllProductss() {
        return ResponseEntity.ok(productClient.getAllProducts()).toString();
    }


    @GetMapping("/fetchProduct/{id}")
    public ResponseEntity<Product> fetchProduct(@PathVariable int id) {
        return ResponseEntity.ok(productClient.getProduct(id));
    }

    @RequestMapping(value = "/create",
            produces = "application/json",
            consumes = "application/json",
            method = {RequestMethod.GET, RequestMethod.PUT})

//    @ApiResponses(@ApiResponse(responseCode = "200", description = "Create", content = @Content(schema = @Schema(implementation = Product.class))))
//    @Operation(tags = TAG, description = "Returnerer beskrivelse")
    public void createProduct(@RequestBody Product product) {
    }

}