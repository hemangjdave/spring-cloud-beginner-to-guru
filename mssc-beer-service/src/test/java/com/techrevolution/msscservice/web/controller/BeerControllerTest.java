package com.techrevolution.msscservice.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techrevolution.msscservice.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getBeer() throws Exception {
        mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

    @Test
    void saveBeer() throws Exception {

        BeerDto beerDto = BeerDto.builder().build();
        String beerDtoString = objectMapper.writeValueAsString(beerDto);
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder =
                post("/api/v1/beer/").
                        contentType(MediaType.APPLICATION_JSON).
                        content(beerDtoString);
        mockMvc.perform(mockHttpServletRequestBuilder)
                .andExpect(status().isCreated());

    }

    @Test
    void updatedBeerById() throws Exception {

        BeerDto beerDto = BeerDto.builder().build();
        String beerDtoString = objectMapper.writeValueAsString(beerDto);
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder =
                put("/api/v1/beer/" + UUID.randomUUID().toString()).
                        contentType(MediaType.APPLICATION_JSON).
                        content(beerDtoString);
        mockMvc.perform(mockHttpServletRequestBuilder)
                .andExpect(status().isNoContent());
    }
}
