package com.lundstad.playground;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import lombok.Getter;

@Getter
public class EmployeeControllerFeignClientBuilder {
    private EmployeeClient employeeClient; // = createClient(ProductClient.class, "http://localhost:8081");

    public EmployeeControllerFeignClientBuilder(String url) {
        this.employeeClient = createClient(EmployeeClient.class, url);
    }

    private static <T> T createClient(Class<T> type, String uri) {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(type))
                .logLevel(Logger.Level.FULL)
                .target(type, uri);
    }
}
