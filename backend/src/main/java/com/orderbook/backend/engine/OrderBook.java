package com.orderbook.backend.engine;

import com.orderbook.backend.model.Order;

import java.util.PriorityQueue;

public class OrderBook {

    private final PriorityQueue<Order> buyOrders =
            new PriorityQueue<>((a, b) ->
                    Double.compare(b.getPrice(), a.getPrice()));

    private final PriorityQueue<Order> sellOrders =
            new PriorityQueue<>((a, b) ->
                    Double.compare(a.getPrice(), b.getPrice()));

    public void addOrder(Order order) {

        if ("BUY".equalsIgnoreCase(order.getSide())) {
            buyOrders.add(order);
        } else {
            sellOrders.add(order);
        }

        matchOrders();
    }

    public void matchOrders() {

        while (!buyOrders.isEmpty() && !sellOrders.isEmpty()) {

            Order bestBuy = buyOrders.peek();
            Order bestSell = sellOrders.peek();

            if (bestBuy.getPrice() < bestSell.getPrice()) {
                break;
            }

            int tradedQuantity =
                    Math.min(bestBuy.getQuantity(), bestSell.getQuantity());

            bestBuy.setQuantity(
                    bestBuy.getQuantity() - tradedQuantity);

            bestSell.setQuantity(
                    bestSell.getQuantity() - tradedQuantity);

            System.out.println(
                    "TRADE: " +
                    tradedQuantity +
                    " @ " +
                    bestSell.getPrice());

            if (bestBuy.getQuantity() == 0) {
                buyOrders.poll();
            }

            if (bestSell.getQuantity() == 0) {
                sellOrders.poll();
            }
        }
    }

    public PriorityQueue<Order> getBuyOrders() {
        return buyOrders;
    }

    public PriorityQueue<Order> getSellOrders() {
        return sellOrders;
    }
}