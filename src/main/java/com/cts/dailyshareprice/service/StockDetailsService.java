package com.cts.dailyshareprice.service;

import com.cts.dailyshareprice.exception.StocksNameNotFoundException;
import com.cts.dailyshareprice.model.StockDetails;
import com.cts.dailyshareprice.repository.SharePriceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockDetailsService {

    @Autowired
    private SharePriceDao sharePriceRepository;

    public StockDetails getStockDetails(String stockName) throws StocksNameNotFoundException {

        StockDetails stockDetails = sharePriceRepository.findByStockName(stockName);
        if(stockDetails == null) {
            throw new StocksNameNotFoundException("Stock not found");
        }
        return stockDetails;
    }

}
