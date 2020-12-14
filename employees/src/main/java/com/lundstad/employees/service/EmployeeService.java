package com.lundstad.employees.service;

import com.lundstad.employees.db.tables.tables.pojos.Employee;
import com.lundstad.employees.db.tables.tables.pojos.EmployeeAddress;
import com.lundstad.employees.exception.ResourceNotFoundException;
import org.jooq.Result;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface EmployeeService {

    Employee createEmployee(com.lundstad.employees.model.Employee employee);

    Employee updateEmployee( Employee employee );

    void deleteEmployee(int id) throws ResourceNotFoundException;

    Collection<Employee> getEmployees();

    Employee getEmployee(int id);

    Result<?> getEmployeesAndAdresses();
    Map<Employee, List<EmployeeAddress>> getEmployeesAndAdresses(Integer id) throws Exception;
}
