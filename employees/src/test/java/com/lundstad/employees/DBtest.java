package com.lundstad.employees;

import com.lundstad.employees.db.tables.tables.EmployeeAddress;
import com.lundstad.employees.service.EmployeeService;
import org.jooq.Record2;
import org.jooq.Result;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.lundstad.employees.db.tables.tables.Employee.EMPLOYEE;
import static org.junit.jupiter.api.Assertions.*;




@SpringBootTest
class DBTest {
    @Autowired
    EmployeeService employeeService;


    @Test
    void contextLoads() {
    }

    @Test
    public void testGetEmployeeAndAddresses(){
        Result<Record2> result  = (Result<Record2>) employeeService.getEmployeesAndAdresses();
        assertTrue( result.getValue(0, EMPLOYEE.FIRSTNAME).equals("Donald")  );
        assertTrue( result.getValue(0, EmployeeAddress.EMPLOYEE_ADDRESS.STREET).equals("Kvakkeveien 1"));
        assertTrue( result.getValue(2, EMPLOYEE.FIRSTNAME).equals("Mickey")  );
        assertEquals(result.getValue(2, EmployeeAddress.EMPLOYEE_ADDRESS.STREET), "Kattehuset 10");
        assertFalse( result.getValue(2, EmployeeAddress.EMPLOYEE_ADDRESS.STREET).equals("Kattehuset 11"));


    }

    @Test
    public void testInsertIntoEmployee(){
        com.lundstad.employees.model.Employee modelEmployee = new com.lundstad.employees.model.Employee(0,"Dole", "Duck", "dole1@email1.com");
        com.lundstad.employees.db.tables.tables.pojos.Employee resultEmployee  = (com.lundstad.employees.db.tables.tables.pojos.Employee) employeeService.createEmployee(modelEmployee);
        assertEquals(resultEmployee.getFirstname(),modelEmployee.getFirstname());
    }

//    var typeRef = new ParameterizedTypeReference<List<Department>>() {
//        // nothing_here
//    };

}