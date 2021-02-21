package com.lundstad.playground;

//import com.lundstad.playground.model.Product;
//import feign.Feign;
//import feign.Headers;
//import feign.Logger;
//import feign.RequestLine;
//import feign.gson.GsonDecoder;
//import feign.gson.GsonEncoder;
//import feign.okhttp.OkHttpClient;
//import feign.slf4j.Slf4jLogger;
//import org.springframework.cloud.openfeign.FeignClient;

//
//@FeignClient(name = "employees-service", url = "http://employees-service:8090") //,configuration = ShopServiceConfiguration.class)


public interface EmployeeClient {
//TODO: SJekk hva som skjer om url endres her og i product-service. Nå matcher de

//    @RequestMapping(value = "/employees", method = RequestMethod.GET) //Spring Web
//    @RequestLine("GET /employees")
//    public List<com.lundstad.employees.model.Employee> getAllProducts();

}
//
//class EmployeeControllerFeignClientBuilder {
//    private EmployeeClient employeeClient;
//
//    public EmployeeControllerFeignClientBuilder(String url) {
//        this.employeeClient = createClient(EmployeeClient.class, url);
//    }
//
//    private static <T> T createClient(Class<T> type, String uri) {
//        return Feign.builder()
//                .client(new OkHttpClient())
//                .encoder(new GsonEncoder())
//                .decoder(new GsonDecoder())
//                .logger(new Slf4jLogger(type))
//                .logLevel(Logger.Level.FULL)
//                .target(type, uri);
//    } }
