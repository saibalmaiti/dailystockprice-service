package com.cts.dailyshareprice.model;

import javax.persistence.*;

@Entity
@Table(name = "stock_details")
public class StockDetails {

    @Id
    private int stockId;
    @Column(name = "stock_name", nullable = false)
    private String stockName;
    @Column(name = "stock_value", nullable = false)
    private double stockValue;

    public StockDetails(){}

    public StockDetails(int stockId, String stockName, double stockValue) {
        this.stockId = stockId;
        this.stockName = stockName;
        this.stockValue = stockValue;
    }

    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public double getStockValue() {
        return stockValue;
    }

    public void setStockValue(double stockValue) {
        this.stockValue = stockValue;
    }

}
