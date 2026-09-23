package com.orderbook.backend.model;

public class Order {

    private String id;
    private String side;
    private double price;
    private int quantity;

    public Order() {
    }

    public Order(String id, String side, double price, int quantity) {
        this.id = id;
        this.side = side;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}