package com.hackerrank.sample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testFilterByPrice_withResults() throws Exception {
        System.out.println("Start testFilterByPrice_withResults() ");

        mockMvc.perform(get("/filter/price/1000/4000")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(greaterThan(0))))
                .andExpect(jsonPath("$[0].item", notNullValue()));
        System.out.println("Success testFilterByPrice_withResults() ");

    }

    @Test
    public void testFilterByPrice_noResults() throws Exception {
        System.out.println("Start testFilterByPrice_noResults() ");
        mockMvc.perform(get("/filter/price/1/10")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
        System.out.println("Success testFilterByPrice_noResults() ");

    }

    @Test
    public void testSortByPrice() throws Exception {
        System.out.println("Start testSortByPrice() ");
        mockMvc.perform(get("/sort/price")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(greaterThan(0))))
                .andExpect(jsonPath("$[0]", notNullValue()));
        System.out.println("Success testSortByPrice() ");

    }

    @Test
    public void filterByPrice_returnsProductsInRange() throws Exception {
        System.out.println("Start filterByPrice_returnsProductsInRange() ");
        mockMvc.perform(get("/filter/price/1000/4000")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(greaterThan(0))))
                .andExpect(jsonPath("$[0].item", notNullValue()));
        System.out.println("Success filterByPrice_returnsProductsInRange() ");
    }

    @Test
    public void filterByPrice_returns400WhenNoProducts() throws Exception {
        System.out.println("Start filterByPrice_returns400WhenNoProducts() ");
        mockMvc.perform(get("/filter/price/1/10")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
        System.out.println("success filterByPrice_returns400WhenNoProducts() ");

    }
}
