//package com.hackerrank.sample;
/*
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;
import java.util.Collections;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    void filterByPrice_returnsProducts() throws Exception {
        Product p = new Product("1", "Test", "Cat", 100, 0, 1);
        when(productService.filterByPrice(50, 150)).thenReturn(Arrays.asList(p));
        mockMvc.perform(get("/filter/price/50/150"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].item").value("Test"));
    }

    @Test
    void filterByPrice_returnsBadRequest() throws Exception {
        when(productService.filterByPrice(5000, 6000)).thenReturn(Collections.emptyList());
        mockMvc.perform(get("/filter/price/5000/6000"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void sortByPrice_returnsSortedNames() throws Exception {
        when(productService.sortByPrice()).thenReturn(Arrays.asList("A", "B"));
        mockMvc.perform(get("/sort/price"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]").value("A"))
                .andExpect(jsonPath("$[1]").value("B"));
    }*/
//}