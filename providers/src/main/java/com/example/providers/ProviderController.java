package com.example.providers;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import io.swagger.annotations.OpenAPIDefinition;
import io.swagger.annotations.Operation;
import io.swagger.annotations.info.Contact;
import io.swagger.annotations.info.Info;
import io.swagger.annotations.media.Content;
import io.swagger.annotations.media.Schema;
import io.swagger.annotations.responses.ApiResponse;
import io.swagger.annotations.servers.Server;
import io.swagger.annotations.tags.Tag;
import org.springframework.stereotype.Component;

import java.util.Collection;

public class ProviderController {

    @GetMapping(value = "/greeting")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "Beskrivelse", content = @Content(schema = @Schema(implementation = Product.class))))
    @Operation(tags = TAG, description = "Returnerer beskrivelse")
    public ResponseEntity<Object> greeting() {
        return new ResponseEntity<>("Denne applikasjonen returnerer providers", HttpStatus.OK);
    }

    @GetMapping(value = "/products")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "henter alle produkter", content = @Content(schema = @Schema(implementation = Product.class))))
    @Operation(tags = TAG, description = "Henter alle produkter")
    public Object[] getProducts() {
        Collection<Product> values = productService.getProducts();
        System.out.println("Products: " + values.size());
        return values.toArray();
    }
}
