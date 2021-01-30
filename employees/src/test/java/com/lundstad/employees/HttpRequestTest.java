package com.lundstad.employees;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class HttpRequestTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void getOneEmployee() throws Exception {
        String uri = "/employees/1";
//        mvc.perform(get("/greeting")).andDo(print()).andExpect(status().isOk())
//                .andExpect(content().string(containsString("Denne applikasjonen returnerer produkter")));
        mvc.perform( MockMvcRequestBuilders
                .get(uri)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstname").value("Donald"));
    }

    @Test
    void getAllEmployee() throws Exception {
        String uri = "/employees";
//        mvc.perform(get("/greeting")).andDo(print()).andExpect(status().isOk())
//                .andExpect(content().string(containsString("Denne applikasjonen returnerer produkter")));
        mvc.perform( MockMvcRequestBuilders
                .get(uri)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].firstname").value("Donald"));
    }
}
