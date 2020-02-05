package com.company;

public class MarketItem {

    Boolean success;
    String lowest_price;
    String volume;
    String median_price;


    @Override
    public String toString() {
        return "MarketItem{" +
                "success=" + success +
                ", lowest_price='" + lowest_price + '\'' +
                ", volume='" + volume + '\'' +
                ", median_price='" + median_price + '\'' +
                '}';
    }
}
