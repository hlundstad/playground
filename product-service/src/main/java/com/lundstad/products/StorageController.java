package com.lundstad.products;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StorageController {
    private final StorageService service;

    public StorageController(StorageService service) {
        this.service = service;
    }
    @RequestMapping("/storage")
//    @Path("/storage")
    public @ResponseBody String storage(){
        return service.hello();
    }

}
