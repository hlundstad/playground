package com.lundstad.playground;

import com.lundstad.playground.model.Employee;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "employees-service", url = "http://employees-service:8090") //,configuration = ShopServiceConfiguration.class)

public interface EmployeeClient {

    @RequestMapping(value = "/employees", method = RequestMethod.GET) //Spring Web
    @RequestLine("GET /employees")
    public List<Employee> getAllEmployees();

}
