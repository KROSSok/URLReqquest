package com.company;

public class MarketItem {

    private Boolean success;
    private String lowest_price;
    private String volume;
    private String median_price;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getLowest_price() {
        return lowest_price;
    }

    public void setLowest_price(String lowest_price) {
        this.lowest_price = lowest_price;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getMedian_price() {
        return median_price;
    }

    public void setMedian_price(String median_price) {
        this.median_price = median_price;
    }

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
