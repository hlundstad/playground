package com.lundstad.playground;

import feign.codec.Encoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import javax.annotation.PostConstruct;

public class ShopServiceConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(ShopServiceConfiguration.class);

    @PostConstruct
    public void postConstruct(){
        System.out.println("ShopServiceModuleConfiguration modul loaded!");
        logger.info("BOOKING MODULE LOADED!");
    }


//    https://github.com/dihnatsyeu/blazemeter-FeignClientsFramework
//    https://www.blazemeter.com/blog/Rest-API-testing-with-Spring-Cloud-Feign-Clients

    public Encoder feignEncoder() {

        HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter();

        ObjectFactory<HttpMessageConverters> objectFactory = () -> new HttpMessageConverters(jacksonConverter);

        return new SpringEncoder(objectFactory);

    }

}
