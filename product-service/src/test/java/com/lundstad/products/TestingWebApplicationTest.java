package com.lundstad.products;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class TestingWebApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void init() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk());

    }


    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/greeting")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Denne applikasjonen returnerer produkter")));
    }

    @Test
    public void deleteProduct() throws Exception {
        this.mockMvc.perform(get("/delete/{id}", 1))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getProduct() throws Exception {
        this.mockMvc.perform(get("/product/{id}", 2))
                .andDo(print())
                .andExpect(status().isOk());
    }



}
