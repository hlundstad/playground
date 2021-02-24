package com.lundstad.playground;

import com.lundstad.playground.model.Employee;
import feign.Headers;
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

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    @RequestLine("POST /create")
    @Headers("Content-Type: application/json")
    public Employee createEmployee(Employee employee);

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT)
    @RequestLine("PUT /create")
    @Headers("Content-Type: application/json")
    public void updateEmployee(Employee employee);

}
