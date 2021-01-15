package com.lundstad.employees;

import com.lundstad.employees.controller.EmployeeController;
import com.lundstad.employees.db.tables.tables.pojos.Employee;
import com.lundstad.employees.service.EmployeeService;
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

@WebMvcTest(controllers = EmployeeController.class)
public class MockitoTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Test
    public void getAllEmployees() throws Exception {

        List<Employee> employeesList = new ArrayList<>();
        employeesList.add(new Employee(1,"Donald","Duck","asd@adf.com"));

        given(employeeService.getEmployees()).willReturn(employeesList);

        this.mockMvc.perform(get("/employees"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(employeesList.get(0).getId()))
                        ;

    }


}
