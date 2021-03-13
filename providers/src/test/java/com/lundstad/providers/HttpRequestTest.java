package com.lundstad.providers;

import com.lundstad.providers.db.tables.tables.pojos.Provider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class HttpRequestTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void getOneProvider() {
        Provider value= restTemplate.getForObject("/provider/1", Provider.class,1);
        assertThat(value.getId(), is(1) ) ;
    }

//    @Test
//    public void wrongEmail() throws Exception {
//        //TODO lag test
//        Provider value= restTemplate.getForObject("/provider/create", Provider.class,1);
//        assertThat(i == 4) ;
//    }
//
//    @Test
//    public void newProviderCreated() throws Exception {
//        Provider p1 = new Provider("Barak", "email@email.no");
//        HttpEntity<Provider> request = new HttpEntity<>(new Provider(++i, "Barak", "Obama"));
//        restTemplate.exchange("/provider/create", HttpMethod.PUT, request, Void.class);
//        Provider value= restTemplate.getForObject("/provider/{i}", Provider.class, i);
//        assertThat(value.id == i) ;
//    }


//    @Test
//    public void getOneProviderByJooq() throws Exception {
//        Provider value= restTemplate.getForObject("/newEmployee", Provider.class,1);
//        assertThat(value.id == 1) ;
//    }
}

