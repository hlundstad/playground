package com.lundstad.providers;

import com.lundstad.providers.db.tables.tables.pojos.Provider;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
public class ProviderController {

    @Autowired
    ProviderService providerService;

    @GetMapping(value = "/greeting")
    public ResponseEntity<Object> greeting() {
        return new ResponseEntity<>("Denne applikasjonen returnerer providers", HttpStatus.OK);
    }

    @GetMapping(value = "/providers")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "henter alle tilbydere", content = @Content(schema = @Schema(implementation = Provider.class))))
    @Operation(description = "Henter alle providerer")
    public Object[] getProviders() {
        Collection<Provider> values = providerService.getProviders();
        System.out.println("providers: " + values.size());
        return values.toArray();
    }

    @GetMapping(value = "/provider/{id}")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "henter et provider på en id", content = @Content(schema = @Schema(implementation = Provider.class))))
    @Operation(description = "Henter provider for en id")
    public ResponseEntity<Object> getProvider(@PathVariable("id") int id) {
        System.out.println("Søker etter Id: " + id);
        return new ResponseEntity<>(providerService.getProvider(id), HttpStatus.OK);

    }


    @PutMapping("/provider/update")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(@ApiResponse(responseCode = "200", description = "oppdaterer provider", content = @Content(schema = @Schema(implementation = Provider.class))))
    @Operation(description = "Oppdaterer en provider")
    public Provider updateProviders(@PathVariable("id") final String id, @RequestBody final Provider provider) {
        return provider;
    }

    @PutMapping("/provider/create")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(@ApiResponse(responseCode = "200", description = "oppdaterer provider", content = @Content(schema = @Schema(implementation = Provider.class))))
    @Operation(description = "Oppdaterer en provider")
    public ResponseEntity<Object> createProvider(@Valid @RequestBody final Provider provider) {
        providerService.createProvider(provider);
        return new ResponseEntity<>("Provider is created successfully", HttpStatus.CREATED);
    }
}
