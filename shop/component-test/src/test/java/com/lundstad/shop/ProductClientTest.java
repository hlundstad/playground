package com.lundstad.shop;

import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.http.HttpMethod.GET;


public class ProductClientTest extends AbstractShopTest {
//
//    @Autowired
//    private ProductServiceClient productServiceClient;
//@Rule
//public WireMockRule wireMockRule = new WireMockRule(8080);

//
//    @BeforeAll
//    public static void setup() {
//
//        configureFor("http://mock-product-service:", 8082);
//
//
//    }
//    @Test
//    public void testAlive() {
//        WireMock.configureFor("mock-product-service", 8080, "/");
//        verify(exactly(1),getRequestedFor(urlEqualTo("/alive")));
//
////        final String userCreationPath = "/alive";
////        WireMock.stubFor(get(userCreationPath).willReturn(WireMock.ok()).andMatching("Hello"));
//
////        this.productServiceClient.getProduct(1);
//
//        // Some assertions here.
//
////        verify(exactly(1), getRequestedFor(urlEqualTo(userCreationPath)));
//    }


    private final RestTemplate restTemplate = new RestTemplate();
    @Test
    public void wiremockAlive() {
        ResponseEntity<String> exchange  = restTemplate.exchange(WIREMOCK_PRODUCT_SERVICE_URL + "/alive",GET, null, new ParameterizedTypeReference<String>(){});
        System.out.println(exchange.getBody());
        assertThat("Wiremock alive test", exchange.getBody(), equalTo("{\"id\":\"1\",\"type\":\"something\"}"));
    }

    @Test
    public void wiremockGetProducts() {

    }

    @Test
    public void fetchProductss() {
        ResponseEntity<String> exchange  = restTemplate.exchange(SHOP_SERVICE_URL + "/fetchProductss",GET, null, new ParameterizedTypeReference<String>(){});
        System.out.println("fetchProductss(): " +exchange.getBody());
        assertThat("Product service: fetchProducts", exchange.hasBody());  //jsonPath("$..id")

    }

    @Test
    public void fetchOneProduct() {
        ResponseEntity<String> exchange  = restTemplate.exchange(SHOP_SERVICE_URL + "/fetchProduct/1",GET, null, new ParameterizedTypeReference<String>(){});
        System.out.println(exchange.getBody());
        assertThat("Product service: fetchOneProduct", exchange.getBody().equals("{\"id\":1,\"name\":\"Honey\",\"price\":20.0}"));  //jsonPath("$..id")

    }

}
