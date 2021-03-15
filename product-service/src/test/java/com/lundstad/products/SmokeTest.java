package com.lundstad.products;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
@Slf4j
@SpringBootTest
public class SmokeTest{

    @Autowired
    private ProductController productController;


    @Test
    public void contextLoads()  throws Exception {
        log.trace("A TRACE Message");
        log.debug("A DEBUG Message");
        log.info("An INFO Message");
        log.warn("A WARN Message");
        log.error("An ERROR Message");
        assertThat(productController).isNotNull();
    }

}
