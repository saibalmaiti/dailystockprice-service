package com.cts.dailyshareprice.service;

import com.cts.dailyshareprice.exception.StocksNameNotFoundException;
import com.cts.dailyshareprice.model.StockDetails;
import com.cts.dailyshareprice.repository.SharePriceDao;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
public class StockDetailsServiceTest {
    @Mock
    private SharePriceDao sharePriceDao;
    @InjectMocks
    private StockDetailsService service;

    @Test
    void getStockDetailsTest() throws StocksNameNotFoundException {
        StockDetails stockDetails = new StockDetails(2,"TCS",2056.75);
        when(sharePriceDao.findByStockName("TCS")).thenReturn(stockDetails);
        assertEquals(service.getStockDetails("TCS"),stockDetails);
    }
    @Test
    void getMutualFundDetailsException() throws StocksNameNotFoundException {
        when(sharePriceDao.findByStockName("SBI")).thenReturn(null);
        assertThrows(StocksNameNotFoundException.class, ()->{
            service.getStockDetails("SBI");
        });
    }
}
