package ru.aston.homework4.DeadLock;

public class Main {
    public static void main(String[] args) {
        System.out.println("Сервер доставки еды запущен...");

        Order order = new Order("ORD-777", "Пицца Пепперони");
        Courier courier = new Courier("COUR-99", "Алексей");

        DeliveryManager manager = new DeliveryManager(order, courier);

        Thread kitchenThread = new Thread(() -> {
            manager.prepareAndAssign();
        }, "Поток-Кухни");

        Thread deliveryThread = new Thread(() -> {
            manager.acceptAndRoute();
        }, "Поток-Диспетчера");

        kitchenThread.start();
        deliveryThread.start();
    }
}
