package com.lundstad.employees.actuator;

import com.lundstad.employees.service.EmployeeService;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class HealthCheck implements HealthIndicator {

    private final EmployeeService employeeServiceImpl;
    public HealthCheck(EmployeeService employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @Override
    public Health health() {
        int errorCode = check(); // perform some specific health check
        if (errorCode<0){
            return Health.down().build();
        }
        else{
            return  Health.up().withDetail("All good, server is up", errorCode).build();
        }
    }


    public int check() {
        int errorCode = employeeServiceImpl.getEmployees().isEmpty()? -1:1;
        System.out.println(employeeServiceImpl.getEmployees().toString());
        System.out.println(errorCode);
        return errorCode;
    }

}
