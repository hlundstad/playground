package com.lundstad.employees;

import com.lundstad.employees.db.tables.tables.pojos.Employee;
import com.lundstad.employees.db.tables.tables.pojos.EmployeeAddress;
import com.lundstad.employees.service.EmployeeServiceImpl;
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
    EmployeeServiceImpl employeeServiceImp;


//    @Test
//    void contextLoads() {
//    }

    @Test
    void testGeTAllEmployeeAndAddresses(){
        Map<Employee, List<EmployeeAddress>> result  =  employeeServiceImp.getEmployeesAndAdresses();
        if (result.size() == 3) {
//            result.forEach((employee, employeeAddresses) -> {
            result.forEach((employee, employeeAddresses) -> {
                        assertNotNull(employee);
                        assertNotNull(employeeAddresses);
                        if (employee.getId() ==new BigDecimal(1))
                        assertEquals(2,employeeAddresses.size());
                        employeeAddresses.forEach(employeeAddress -> {
                            if (((BigDecimal) employeeAddress.getId()).intValue() == 1) {
                                assertEquals("Kvakkeveien 1", employeeAddress.getStreet());
                            }
                            if (((BigDecimal) employeeAddress.getId()).intValue() == 2) {
                                assertEquals("Hytteveien 100",employeeAddress.getStreet());
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
    void testInsertIntoEmployee(){
        Employee employee = new Employee(null,"Dole", "Duck", "dole1@email1.com");
        com.lundstad.employees.db.tables.tables.pojos.Employee resultEmployee  = employeeServiceImp.createEmployee(employee);
        assertEquals(resultEmployee.getFirstname(),employee.getFirstname());
    }


    @Test
//    @Rollback(true)
    void updateEmployee(){
        Employee jooqEmployee = new Employee(1,"Donald1", null, null);
        Employee resultEmployee  = employeeServiceImp.updateEmployee(jooqEmployee);
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