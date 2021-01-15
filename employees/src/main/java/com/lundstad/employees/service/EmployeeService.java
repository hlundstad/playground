package com.lundstad.employees.service;

import com.lundstad.employees.db.tables.tables.pojos.Employee;
import com.lundstad.employees.db.tables.tables.pojos.EmployeeAddress;
import com.lundstad.employees.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface EmployeeService {

    Employee createEmployee(com.lundstad.employees.model.Employee employee);

    Employee updateEmployee( Employee employee );

    void deleteEmployee(int id) throws ResourceNotFoundException;

    List<Employee> getEmployees();

    Employee getEmployee(int id);

    Map<Employee, List<EmployeeAddress>> getEmployeesAndAdresses();

    Map<Employee, List<EmployeeAddress>> getEmployeesAndAdresses(Integer id) throws Exception;
}
