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
        //Check autowire
        return (employeeServiceImpl.getEmployees().size() < 0 ? Health.down().build() : Health.up().build());
    }
}
