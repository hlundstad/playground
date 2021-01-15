package com.lundstad.employees.controller;

import com.lundstad.employees.db.tables.tables.pojos.Employee;
import com.lundstad.employees.db.tables.tables.pojos.EmployeeAddress;
import com.lundstad.employees.exception.ResourceNotFoundException;
import com.lundstad.employees.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;


@Controller
//@RequestMapping("/api/v1")
public class EmployeeController {
    private final EmployeeService employeeServiceImpl;

    public EmployeeController(EmployeeService employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }




//    @Autowired
//    public void setEmployeeService(EmployeeServiceImpl employeeServiceImpl){
//        this.employeeServiceImpl=employeeServiceImpl;
//    }


    @GetMapping("/employees")
    public List <Employee> getAllEmployees() {
        return employeeServiceImpl.getEmployees();
    }

//    @GetMapping("/employees/{id}")
//    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") int employeeId)
//            throws ResourceNotFoundException {
//        Employee tempEmployee = employeeServiceImpl.getEmployee(employeeId);
//        return ResponseEntity.ok().body(tempEmployee);
//    }
    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable(value = "id") int employeeId)
           // throws ResourceNotFoundException
    {
        Employee tempEmployee = employeeServiceImpl.getEmployee(employeeId);
        return tempEmployee;
    }


    @PostMapping("/employees")
    public Employee createEmployee(@Valid @RequestBody com.lundstad.employees.model.Employee employee) {
        return employeeServiceImpl.createEmployee(employee);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity <Employee> updateEmployee(@PathVariable(value = "id") int employeeId,
                                                      @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
        Employee employee = employeeServiceImpl.updateEmployee(employeeDetails);
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable(value = "id") int employeeId) throws ResourceNotFoundException {
        employeeServiceImpl.deleteEmployee(employeeId);
                //.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
    }

    @GetMapping("/employees/addresses")
    public Map<Employee, List<EmployeeAddress>> getAllEmployeesAndAdress() {
        return employeeServiceImpl.getEmployeesAndAdresses();
    }
}