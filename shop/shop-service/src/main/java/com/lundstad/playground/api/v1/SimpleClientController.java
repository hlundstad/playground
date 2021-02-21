package com.lundstad.playground.api.v1;


import com.lundstad.playground.model.AirQuality;
import com.lundstad.playground.model.Quote;
import com.lundstad.playground.model.SimpleClientData;
import com.lundstad.playground.model.User;
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
        return "Hello, the time at the server is now " + new Date() + "\n";
    }

    @RequestMapping("/alive")
    public String alive() {
        return "Hello, I am alive!" ;
    }

    @RequestMapping("/quora")
    public String quora() {
        Quote quote = template.getForObject(
                "https://freequote.herokuapp.com/", Quote.class);
        return quote.getValue().toString();
    }

    @RequestMapping("/quora2")
    public String quora2() {
        return quote.getValue().getQuote();
    }


    @RequestMapping("/airquality")
    public AirQuality[] airQuality() {
        AirQuality[] airQuality = template.getForObject(
                "https://api.met.no/weatherapi/airqualityforecast/0.1/areas?areaclass=fylke", AirQuality[].class);
        for(AirQuality aq : airQuality){
            System.out.println(aq.getName() + "::" );
        }
        return airQuality;
    }

    @RequestMapping("/user/{userId}")
    public User user(@PathVariable String userId) {
        User user = template.getForObject(
                "https://gorest.co.in/public-api/users/"+ userId, User.class);
        System.out.println(user.getData().toString() + "::" );
        return user;
    }





}
