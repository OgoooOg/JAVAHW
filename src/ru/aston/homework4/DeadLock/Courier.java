package ru.aston.homework4.DeadLock;

public class Courier {
    private final String courierId;
    private final String name;

    public Courier(String courierId, String name) {
        this.courierId = courierId;
        this.name = name;
    }

    public String getCourierId() {
        return courierId;
    }

    public String getName() {
        return name;
    }
}
