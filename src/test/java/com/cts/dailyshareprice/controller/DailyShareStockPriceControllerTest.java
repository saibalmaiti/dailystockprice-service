package com.cts.dailyshareprice.controller;

import com.cts.dailyshareprice.feign.AuthorisingClient;
import com.cts.dailyshareprice.service.StockDetailsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DailyShareStockPriceControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private StockDetailsService service;
    @MockBean
    private AuthorisingClient authClient;

    @Test
    void test1() {
        assertThat(service).isNotNull();
    }
    @Test
    void test2() {
        assertThat(authClient).isNotNull();
    }

    @Test
    void dailyNavWithWrongToken() throws Exception {
        when(authClient.authorizeTheRequest("@uthoriz@tionToken123")).thenReturn(true);
        this.mockMvc.perform(get("/dailySharePrice/TCS").header("Authorization", "@WrongToken"))
                .andExpect(status().isUnauthorized());
    }
    @Test
    void dailyNavWithCorrectToken() throws Exception {
        when(authClient.authorizeTheRequest("@uthoriz@tionToken123")).thenReturn(true);
        this.mockMvc
                .perform(get("/dailySharePrice/TCS").header("Authorization", "@uthoriz@tionToken123"))
                .andExpect(status().isOk());
    }

}
