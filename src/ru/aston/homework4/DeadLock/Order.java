package ru.aston.homework4.DeadLock;

public class Order {
    private final String orderId;
    private final String dishName;

    public Order(String orderId, String dishName) {
        this.orderId = orderId;
        this.dishName = dishName;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getDishName() {
        return dishName;
    }
}
