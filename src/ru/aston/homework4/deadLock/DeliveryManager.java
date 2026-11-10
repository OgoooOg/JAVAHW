package ru.aston.homework4.deadLock;

import java.util.concurrent.CountDownLatch;

public class DeliveryManager {
    private final Order order;
    private final Courier courier;
    private final CountDownLatch latch = new CountDownLatch(2);

    public DeliveryManager(Order order, Courier courier) {
        this.order = order;
        this.courier = courier;
    }

    public void prepareAndAssign() {
        String threadName = "[" + Thread.currentThread().getName() + "]";

        synchronized (order) {
            System.out.println(threadName + " Ресторан начал готовить: " + order.getDishName());
            latch.countDown();
            try {
                latch.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println(threadName + " Поток был прерван во время ожидания.");
                return;
            }

            System.out.println(threadName + " Еда готова! Ищу курьера " + courier.getName() + " для выдачи...");

            synchronized (courier) {
                System.out.println(threadName + " Успех! Заказ выдан курьеру.");
            }
        }
    }

    public void acceptAndRoute() {
        String threadName = "[" + Thread.currentThread().getName() + "]";

        synchronized (courier) {
            System.out.println(threadName + " Курьер " + courier.getName() + " заблокирован в системе (назначен на заказ).");
            latch.countDown();
            try {
                latch.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println(threadName + " Поток был прерван во время ожидания.");
                return;
            }

            System.out.println(threadName + " Маршрут построен! Пытаюсь связать курьера с заказом " + order.getOrderId() + "...");

            synchronized (order) {
                System.out.println(threadName + " Успех! Маршрут привязан к заказу.");
            }
        }
    }
}
