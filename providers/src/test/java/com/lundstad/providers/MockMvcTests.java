package com.lundstad.providers;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebMvcTest
@AutoConfigureMockMvc
@SpringBootTest
public class MockMvcTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getProduct() throws Exception {

        MvcResult resultActions = this.mockMvc.perform(get("/provider/{id}", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        assertTrue(resultActions.getResponse().getContentAsString().contains("Peter"));
    }

    @Test
    public void getProduct2() throws Exception {
        String nameJason = "{\"firstname\":\"Peter\"}";
        Provider expected = new Provider(1, "Peter", "Olsen");
        mockMvc.perform(get("/provider/{id}", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(ResponseBodyMatchers.responseBody().containsObjectAsJson(expected, Provider.class));
    }
}
