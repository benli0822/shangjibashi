package com.menudesigner.sjbs.web.controllers;

import com.menudesigner.sjbs.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(value = "test")
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class IndexControllerTest {

    @Autowired
    private IndexController indexController;

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup() {
        // Process mock annotations
        MockitoAnnotations.initMocks(this);

        // Setup Spring test in webapp-mode (same config as spring-boot)
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testLoadCustomerPage() throws Exception{
        this.mockMvc.perform(get("/"))
                .andExpect(view().name("views/index"))
                .andExpect(status().isOk());
    }
}