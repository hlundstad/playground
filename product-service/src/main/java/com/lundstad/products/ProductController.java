package com.lundstad.products;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;




@RestController
@OpenAPIDefinition(
        info = @Info(title = "Product Service", description = "TestApi produkt service", version = "v1",
                contact = @Contact(email = "h@gmail.com", name = "hege", url = "git")),
        tags = @Tag(name = "product", description = "API hente test produkter"),
        servers = @Server(url = "localhost:8081", description = "Retur produkter"))
public class ProductController {

    public static final String TAG = "Produktregister";
    Logger logger = LoggerFactory.getLogger(ProductController.class);


    @Autowired
    ProductService productService;

//    static {
//        productList.add(new Product(1, "product-1", 12.0));
//        productList.add(new Product(2, "product-2", 34.0));
//        productList.add(new Product(3, "product-3", 9.0));
//    }

    @GetMapping(value = "/products")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "henter alle produkter", content = @Content(schema = @Schema(implementation = Product.class))))
    @Operation(tags = TAG, description = "Henter alle produkter")
    public Object[] getProducts() {
        Collection<Product> values = productService.getProducts();
        System.out.println("Products: " + values.size());
        return values.toArray();
    }

    @GetMapping("/")
    public ResponseEntity<Object> init() {
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @GetMapping("/products2")
    public ResponseEntity<Object> getProduct2() {
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @GetMapping(value = "/product/{id}")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "henter et produkt på en id", content = @Content(schema = @Schema(implementation = Product.class))))
    @Operation(tags = TAG, description = "Henter produkt for en id")
    public ResponseEntity<Object> getProduct(@PathVariable("id") int id) {
        System.out.println("Søker etter Id: " + id);
        return new ResponseEntity<>(productService.getProduct(id), HttpStatus.OK);

    }

    @GetMapping(value = "/greeting")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "Beskrivelse", content = @Content(schema = @Schema(implementation = Product.class))))
    @Operation(tags = TAG, description = "Returnerer beskrivelse")
    public ResponseEntity<Object>greeting() {
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");
        return new ResponseEntity<>("Denne applikasjonen returnerer produkter", HttpStatus.OK);
    }

//    private Product findProduct(Integer id) {
//        System.out.println("Size productlist " + productList.size());
//        return productList.stream()
//                .filter(x -> id.equals(x.getId()))
//                .findAny()
//                .orElse(new Product(100, "null", 10));
//    }

    @RequestMapping(value = "/update/{id}",
            produces = "application/json",
            method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<Object> updateProduct(@PathVariable("id") Integer id, @RequestBody Product product) {
        productService.updateProduct(id, product);
        return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
    }


    @RequestMapping(value = "/delete/{id}",
            produces = "application/json",
            method = {RequestMethod.GET, RequestMethod.DELETE})
    public void deleteProduct(@PathVariable int id) {
        System.out.println("Sletter product: " + id);
        productService.deleteProduct(id);
    }


    @RequestMapping(value = "/create",
            produces = "application/json",
            method = {RequestMethod.GET, RequestMethod.PUT})
    @ApiResponses(@ApiResponse(responseCode = "200", description = "Create", content = @Content(schema = @Schema(implementation = Product.class))))
    @Operation(tags = TAG, description = "Returnerer beskrivelse")
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        productService.createProduct(product);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }

}
