package com.lundstad.providers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {
    static int i = ProviderServiceImpl.getCounter();

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getOneProvider() throws Exception {
        Provider value= restTemplate.getForObject("/provider/1", Provider.class,1);
        assertThat(value.id == 1) ;
    }

    @Test
    public void wrongEmail() throws Exception {
        //TODO lag test
        Provider value= restTemplate.getForObject("/provider/create", Provider.class,1);
        assertThat(i == 4) ;
    }

    @Test
    public void newProviderCreated() throws Exception {
        Provider p1 = new Provider(++i, "Barak", "Obama");
        HttpEntity<Provider> request = new HttpEntity<>(new Provider(++i, "Barak", "Obama"));
        restTemplate.exchange("/provider/create", HttpMethod.PUT, request, Void.class);
        Provider value= restTemplate.getForObject("/provider/{i}", Provider.class, i);
        assertThat(value.id == i) ;
    }
}

