package com.lundstad.employees;

import com.lundstad.employees.db.tables.tables.pojos.Employee;
import com.lundstad.employees.db.tables.tables.pojos.EmployeeAddress;
import com.lundstad.employees.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;



@Transactional
@SpringBootTest
class DBTest {
    @Autowired
    EmployeeService employeeService;


    @Test
    void contextLoads() {
    }

    @Test
    public void testGeTAllEmployeeAndAddresses(){
        Map<Employee, List<EmployeeAddress>> result  =  employeeService.getEmployeesAndAdresses();
        if (result.size() == 3) {
//            result.forEach((employee, employeeAddresses) -> {
            result.forEach((employee, employeeAddresses) -> {
                        assertNotNull(employee);
                        assertNotNull(employeeAddresses);
                        if ((BigDecimal)employee.getId()==new BigDecimal(1))
                        assertTrue(employeeAddresses.size() == 2);
                        employeeAddresses.forEach(employeeAddress -> {
                            if (((BigDecimal) employeeAddress.getId()).intValue() == 1) {
                                assertTrue((employeeAddress.getStreet()).equals("Kvakkeveien 1"));
                            }
                            if (((BigDecimal) employeeAddress.getId()).intValue() == 2) {
                                assertTrue((employeeAddress.getStreet()).equals("Hytteveien 100"));
                            }
                        });


                    }
            );

        }
        else {
            fail("Ikke riktig antall rader fra db");
        }


//
//        assertTrue( result.(0, EMPLOYEE.FIRSTNAME).equals("Donald")  );
//        assertTrue( result.getValue(0, EmployeeAddress.EMPLOYEE_ADDRESS.STREET).equals("Kvakkeveien 1"));
//        assertTrue( result.getValue(1, EmployeeAddress.EMPLOYEE_ADDRESS.STREET).equals("Hytteveien 100"));
//        assertTrue( result.getValue(2, EMPLOYEE.FIRSTNAME).equals("Dolly")  );
//        assertEquals(result.getValue(2, EmployeeAddress.EMPLOYEE_ADDRESS.STREET), "Apalveien 50");
//        assertFalse( result.getValue(2, EmployeeAddress.EMPLOYEE_ADDRESS.STREET).equals("Apalveien 501"));


    }

    @Test
//    @Rollback(true)
    public void testInsertIntoEmployee(){
        com.lundstad.employees.model.Employee modelEmployee = new com.lundstad.employees.model.Employee(null,"Dole", "Duck", "dole1@email1.com");
        com.lundstad.employees.db.tables.tables.pojos.Employee resultEmployee  = (com.lundstad.employees.db.tables.tables.pojos.Employee) employeeService.createEmployee(modelEmployee);
        assertEquals(resultEmployee.getFirstname(),modelEmployee.getFirstname());
    }


    @Test
//    @Rollback(true)
    public void updateEmployee(){
        Employee jooqEmployee = new Employee(1,"Donald1", null, null);
        Employee resultEmployee  = employeeService.updateEmployee(jooqEmployee);
        assertEquals(resultEmployee.getFirstname(),jooqEmployee.getFirstname());
        assertNotNull(resultEmployee.getLastname());
    }

//    @Test
//    @Rollback(true)
//    public void getOneEmployeeAndAdresses() throws Exception {
//        com.lundstad.employees.db.tables.tables.pojos.EmployeeAddress ea;
//        Map<Employee, List<com.lundstad.employees.db.tables.tables.pojos.EmployeeAddress>> result = employeeService.getEmployeesAndAdresses(1);
//        if (result.size() == 2) {
//            result.forEach((employee, employeeAddresses) -> {
//                        assertNotNull(employee);
//                        assertNotNull(employeeAddresses);
//                        assertTrue(employee.getFirstname().equals("Donald"));
//                        assertTrue(employeeAddresses.size() == 1);
//                        employeeAddresses.forEach(employeeAddress -> {
//                            if (((BigDecimal) employeeAddress.getId()).intValue() == 1) {
//                                assertTrue((employeeAddress.getStreet()).equals("Kvakkeveien 1"));
//                            }
//                            if (((BigDecimal) employeeAddress.getId()).intValue() == 2) {
//                                assertTrue((employeeAddress.getStreet()).equals("Hytteveien 100"));
//                            }
//                        });
//
//
//                    }
//            );
//
//        }
//        else {
//            fail("Ikke riktig antall rader fra db");
//        }
//    }

}