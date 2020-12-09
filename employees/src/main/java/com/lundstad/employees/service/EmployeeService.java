package com.lundstad.employees.service;

import com.lundstad.employees.db.tables.tables.pojos.Employee;
import com.lundstad.employees.exception.ResourceNotFoundException;
import org.jooq.Result;

import java.util.Collection;

public interface EmployeeService {
    Employee createEmployee(Employee product);

    Employee updateEmployee(int id, Employee product);

    void deleteEmployee(int id) throws ResourceNotFoundException;

    Collection<Employee> getEmployees();

    Employee getEmployee(int id);

    Result<?> getEmployeesAndAdresses();
}
