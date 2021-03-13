package com.lundstad.providers;


import com.lundstad.providers.db.tables.tables.pojos.Provider;
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
@SpringBootTest class MockMvcTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
     void getProvider() throws Exception {

        MvcResult resultActions = this.mockMvc.perform(get("/provider/1", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        assertTrue(resultActions.getResponse().getContentAsString().contains("Aliko"));
    }

    @Test
     void getProvider2() throws Exception {
        Provider expected = new Provider(2,"Bill","Gates","fol@gmail1.com");
        mockMvc.perform(get("/provider/2", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(ResponseBodyMatchers.responseBody().containsObjectAsJson(expected, Provider.class));
    }
}
