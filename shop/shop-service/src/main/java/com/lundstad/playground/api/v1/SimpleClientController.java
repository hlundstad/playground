package com.lundstad.playground.api.v1;

import com.lundstad.playground.model.Quote;
import com.lundstad.playground.model.SimpleClientData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@RestController
public class SimpleClientController {
    @Autowired
    private RestTemplate template;

    @Autowired
    private Quote  quote;

    @GetMapping("/data/{dataId}")
    public SimpleClientData getData(@PathVariable int dataId) {
        return new SimpleClientData(dataId, "name-" + dataId, dataId * 2);
    }

    @RequestMapping("/")
    public String index() {
        return "Hello, the time at the shop server is now " + new Date() + "\n";
    }

    @RequestMapping("/alive")
    public String alive() {
        return "Hello, I am alive!" ;
    }

    @RequestMapping("/quora2")
    public String quora2() {
        return quote.getValue().getQuote();
    }







}
