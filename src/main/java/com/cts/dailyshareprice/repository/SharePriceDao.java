package com.cts.dailyshareprice.repository;

import com.cts.dailyshareprice.model.StockDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SharePriceDao extends JpaRepository<StockDetails, Integer> {
    public StockDetails findByStockName(String stockName);
}
