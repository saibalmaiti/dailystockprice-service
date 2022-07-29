package com.cts.dailyshareprice.model;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class StockDetailsTest {
    @Mock
    StockDetails stockDetails;
    @Test
    void StockDetailsWithNoArgument() {
        assertThat(new StockDetails()).isNotNull();
    }
    @Test
    void StockDetailsWithArgumnet() {
        assertThat(new StockDetails(1,"TCS",2451.54)).isNotNull();
    }
    @Test
    void getStockIdTest() {
        when(stockDetails.getStockId()).thenReturn(1);
        assertEquals(stockDetails.getStockId(),1);
    }
    @Test
    void getStockNameTest() {
        when(stockDetails.getStockName()).thenReturn("TCS");
        assertEquals(stockDetails.getStockName(),"TCS");
    }
    @Test
    void getStockValueTest() {
        when(stockDetails.getStockValue()).thenReturn(1024.2);
        assertEquals(stockDetails.getStockValue(),1024.2);
    }
}
