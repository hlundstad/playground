package com.lundstad.employees.controller;

import com.lundstad.employees.db.tables.tables.pojos.Employee;
import com.lundstad.employees.db.tables.tables.pojos.EmployeeAddress;
import com.lundstad.employees.exception.ResourceNotFoundException;
import com.lundstad.employees.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.Map;


@Controller
//@RequestMapping("/api/v1")
public class EmployeeController {
    private final EmployeeService employeeServiceImpl;

    public EmployeeController(EmployeeService employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }


    @GetMapping(value = "/employees")
    public @ResponseBody List <Employee> getAllEmployees() {
        Collection<Employee> values = employeeServiceImpl.getEmployees();
        System.out.println("employees: " + values.size());
        return employeeServiceImpl.getEmployees();
    }


    @GetMapping("/employees/{id}")
    public @ResponseBody Employee getEmployeeById(@PathVariable(value = "id") int employeeId)
    {
        return employeeServiceImpl.getEmployee(employeeId);
    }

    @PostMapping("/employees")
    public @ResponseBody Employee createEmployee(@Valid @RequestBody Employee employee) {
        return employeeServiceImpl.createEmployee(employee);
    }

    @PutMapping("/employees/{id}")
    public @ResponseBody Employee updateEmployee(@PathVariable(value = "id") int employeeId,
                                                      @Valid @RequestBody Employee employeeDetails) {
        return employeeServiceImpl.updateEmployee(employeeDetails);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable(value = "id") int employeeId) throws ResourceNotFoundException {
        employeeServiceImpl.deleteEmployee(employeeId);
    }

    @GetMapping("/employees/addresses")
    public  @ResponseBody Map<Employee, List<EmployeeAddress>> getAllEmployeesAndAdress() {
        return employeeServiceImpl.getEmployeesAndAdresses();
    }
}