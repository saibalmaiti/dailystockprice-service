package com.cts.dailyshareprice.controller;

import com.cts.dailyshareprice.exception.AuthorizationException;
import com.cts.dailyshareprice.exception.StocksNameNotFoundException;
import com.cts.dailyshareprice.feign.AuthorisingClient;
import com.cts.dailyshareprice.model.StockDetails;
import com.cts.dailyshareprice.service.StockDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class DailySharePriceController {

    private StockDetailsService stockDetailsService;
    private AuthorisingClient authorisingClient;
    @Autowired
    public void setStockDetailsService(StockDetailsService stockDetailsService) {
        this.stockDetailsService = stockDetailsService;
    }
    @Autowired
    public void setAuthorisingClient(AuthorisingClient authorisingClient) {
        this.authorisingClient = authorisingClient;
    }

    @GetMapping("/dailySharePrice/{stockName}")
    public StockDetails getDailySharePrice(@RequestHeader(value = "Authorization", required = true) String requestTokenHeader,
                                           @PathVariable() String stockName) throws StocksNameNotFoundException, AuthorizationException {
        System.out.println("Getting Current Stock Value............");
        if(authorisingClient.authorizeTheRequest(requestTokenHeader)){
            return stockDetailsService.getStockDetails(stockName);
        }
        else {
            throw new AuthorizationException("Not allowed");
        }
    }

}
