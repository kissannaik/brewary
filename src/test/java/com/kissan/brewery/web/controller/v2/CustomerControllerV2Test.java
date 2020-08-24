package com.kissan.brewery.web.controller.v2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kissan.brewery.web.model.v2.CustomerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerControllerV2.class)
class CustomerControllerV2Test {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getCustomer() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v2/customer/"+ UUID.randomUUID().toString())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void addCustomer() throws Exception {
        CustomerDTO customerDTO = CustomerDTO.builder().name("Bill Morris").build();
        String customerDTOJson = objectMapper.writeValueAsString(customerDTO);

        mockMvc.perform(post("/api/v2/customer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(customerDTOJson))
                .andExpect(status().isCreated());
    }

    @Test
    void updateCustomer() throws Exception {
        CustomerDTO customerDTO = CustomerDTO.builder().name("Jack Morris").build();
        String customerDTOJson = objectMapper.writeValueAsString(customerDTO);

        mockMvc.perform(put("/api/v2/customer"+ UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(customerDTOJson))
                .andExpect(status().isOk());
    }

    @Test
    void deleteCustomer() throws Exception {
        mockMvc.perform(delete("/api/v2/customer"+ UUID.randomUUID().toString())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}