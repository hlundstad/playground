package com.lundstad.employees;

import com.lundstad.employees.controller.EmployeeController;
import com.lundstad.employees.db.tables.tables.pojos.Employee;
import com.lundstad.employees.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
class MockitoTests {
    @Autowired
    private MockMvc mockMvc;

    //    @Spy
    @MockBean
    private EmployeeService employeeService;
    private List<Employee> employeesList;
    @BeforeEach()
    void init() {
        employeesList = new ArrayList<>();
        employeesList.add(new Employee(1, "Donald", "Duck", "asd@adf.com"));
    }
    @Test
    void getAllEmployees() throws Exception {
        given(employeeService.getEmployees()).willReturn(employeesList);

        this.mockMvc.perform(get("/employees"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(employeesList.get(0).getId()))
                        ;

    }


}
