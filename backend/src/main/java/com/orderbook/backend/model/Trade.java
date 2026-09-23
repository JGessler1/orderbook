package com.orderbook.backend.model;

public class Trade {

    private String buyOrderId;
    private String sellOrderId;
    private double price;
    private int quantity;
    private long timestamp;

    public Trade(
            String buyOrderId,
            String sellOrderId,
            double price,
            int quantity) {

        this.buyOrderId = buyOrderId;
        this.sellOrderId = sellOrderId;
        this.price = price;
        this.quantity = quantity;
        this.timestamp = System.currentTimeMillis();
    }

    public String getBuyOrderId() {
        return buyOrderId;
    }

    public String getSellOrderId() {
        return sellOrderId;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public long getTimestamp() {
        return timestamp;
    }
}