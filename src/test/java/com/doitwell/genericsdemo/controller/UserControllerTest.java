package com.doitwell.genericsdemo.controller;

import com.doitwell.genericsdemo.model.Admin;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class UserControllerTest {

    @Autowired
    WebApplicationContext context;
    @Autowired
    ObjectMapper objectMapper;
    MockMvc mvc;

    @BeforeEach
    void setup(){
        this.mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    void givenUserId_whenGetOne_thenReturnUser() throws Exception {
        final Long userId = 10L;

        this.mvc.perform(MockMvcRequestBuilders.get("/users/"+userId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstname",is("Ella")))
                .andExpect(jsonPath("$.lastname",is("Toung")));

    }

    @Test
    void createOne() throws Exception {

        Admin admin = new Admin();
        admin.setFirstname("Nsourou Toung");
        admin.setLastname("Marcelline");
        admin.setEmail("marce@email.com");
        admin.setPassword("Marce1234");
        admin.setConnected(true);
        this.mvc.perform(MockMvcRequestBuilders.post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(admin))
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstname",is("Nsourou Toung")))
                .andExpect(jsonPath("$.lastname",is("Marcelline")));
    }
}