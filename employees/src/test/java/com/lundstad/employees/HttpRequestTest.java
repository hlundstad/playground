package com.lundstad.employees;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.lundstad.employees.controller.EmployeeController;
import com.lundstad.employees.db.tables.tables.pojos.Employee;
import com.lundstad.employees.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.client.RestClientException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {
//    @Autowired
//    private ApplicationContext context;

    @Autowired
    private static WebTestClient client;
//    private static WebTestClient client;

    @MockBean
    private EmployeeService employeeService;

    @Autowired
    private EmployeeController employeeController;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

//    @BeforeEach
//    public static void setUp() {
//        client = WebTestClient.bindToController(employeeController)
//                .build();
//    }



    @Test
    public void getOneEmployee() throws Exception {

//        WebTestClient testClient = WebTestClient.bindToApplicationContext(context)
//                .build();
        client = WebTestClient.bindToController(employeeController)
                .build();
        Void response = client.get().uri("/employees/1")
                .exchange()
                .expectStatus().isCreated()
                .expectHeader().valueEquals("Content-Type", "application/json")
                .expectBody().isEmpty()
                .getResponseBody();
        response.toString();
//
//        Employee value= restTemplate.getForObject("/employees/1", Employee.class,1);
//        assertThat(value.getId().equals(String.valueOf(1))) ;
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
    @Test
    @JsonDeserialize(keyUsing = MapKeyDeserializer.class)
    public void getAllEmployeesAndAdresses() throws Exception {
        try {
            client = WebTestClient.bindToController(employeeController)
                    .build();
            client.get().uri("/employees/addresses")
                    .exchange()
                    .expectStatus().isCreated()
                    .expectHeader().valueEquals("Content-Type", "application/json")
                    .expectBody().isEmpty();





//            ResponseEntity<LinkedHashMap<Employee, ArrayList<EmployeeAddress>>> response = restTemplate.exchange(
//                    "/employees/addresses",
//                    HttpMethod.GET,
//                    null,
//                    new ParameterizedTypeReference<>() {
//                    });
//            if (response != null && response.hasBody()) {
//                Object result = response.getBody();
//                assertThat(result!=null);
//            }
        } catch (RestClientException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public class EmployeeList {
        private List<Employee> employees;

        public EmployeeList() {
            employees = new ArrayList<>();
        }

        // standard constructor and getter/setter
    }


    public class MapKeyDeserializer extends KeyDeserializer {

        private  final ObjectMapper mapper = new ObjectMapper();

        @Override
        public Object deserializeKey(String key, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            return mapper.readValue(key, Employee.class);
        }
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
