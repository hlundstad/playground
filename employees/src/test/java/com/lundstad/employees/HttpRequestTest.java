package com.lundstad.employees;


import com.lundstad.employees.db.tables.tables.pojos.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getOneEmployee() throws Exception {
        Employee value= restTemplate.getForObject("/employees/1", Employee.class,1);
        assertThat(value.getId().equals(String.valueOf(1))) ;
    }

    @Test
    public void getAllEmployees() throws Exception {
        try {
            ResponseEntity<List<Employee>> response = restTemplate.exchange(
                    "/employees",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Employee>>() {
                    });
            if (response != null && response.hasBody()) {
                List<Employee> employees = response.getBody();
                assertThat(employees.size() == 3);
            }
        } catch (RestClientException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
//    @Test
//    public void getAllEmployeesAndAdresses() throws Exception {
//        try {
//            ResponseEntity<Object> response = restTemplate.exchange(
//                    "/all",
//                    HttpMethod.GET,
//                    null,
//                    new ParameterizedTypeReference<Object>() {
//                    });
//            if (response != null && response.hasBody()) {
//                Object result = response.getBody();
//                assertThat(result!=null);
//            }
//        } catch (RestClientException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }

    public class EmployeeList {
        private List<Employee> employees;

        public EmployeeList() {
            employees = new ArrayList<>();
        }

        // standard constructor and getter/setter
    }
}

//    @Test
//    public void wrongEmail() throws Exception {
//        //TODO lag test
//        Provider value= restTemplate.getForObject("/provider/create", Provider.class,1);
//        assertThat(i == 4) ;
//    }

//    @Test
//    public void newProviderCreated() throws Exception {
//        Provider p1 = new Provider(++i, "Barak", "Obama");
//        HttpEntity<Provider> request = new HttpEntity<>(new Provider(++i, "Barak", "Obama"));
//        restTemplate.exchange("/provider/create", HttpMethod.PUT, request, Void.class);
//        Provider value= restTemplate.getForObject("/provider/{i}", Provider.class, i);
//        assertThat(value.id == i) ;
//    }
//

//    @Test
//    public void getOneProviderByJooq() throws Exception {
//        Provider value= restTemplate.getForObject("/newEmployee", Provider.class,1);
//        assertThat(value.id == 1) ;
//    }
