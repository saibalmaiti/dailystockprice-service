package com.cts.dailyshareprice.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@DataJpaTest
public class SharePriceDaoTest {
    @Autowired
    private SharePriceDao sharePriceDao;

    @Test
    public void testGetStockByName() {
        assertNotNull(sharePriceDao.findByStockName("INFY"));
    }
    @Test
    public void testGetStockByWrongName() {
        assertNull(sharePriceDao.findByStockName("SBI"));
    }
}
