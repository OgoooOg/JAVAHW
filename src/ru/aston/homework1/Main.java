package ru.aston.homework1;

public class Main {
    public static void main(String[] args) {
        Car myCar = new Car("Черный");
        CarSale saleRecord = new CarSale("Олег", myCar);

        System.out.println("--- Проверка 1: Загрузка отчёта ---");
        System.out.println("Исходный отчёт в базе: " + saleRecord);

        myCar.setColor("Красный");

        if ("Черный".equals(saleRecord.getCar().getColor())) {
            System.out.println("Результат проверки: Успех! В отчёте остался Чёрный цвет.");
        } else {
            System.out.println("Результат проверки: Ошибка! Иммутабельность сломана.");
        }

        System.out.println("\n--- Проверка 2: Попытка взлома через геттер ---");
        Car stolenCar = saleRecord.getCar();
        stolenCar.setColor("Зеленый");

        if ("Черный".equals(saleRecord.getCar().getColor())) {
            System.out.println("Результат проверки: Успех! После вызова геттера оригинал остался Чёрным.");
        } else {
            System.out.println("Результат проверки: Ошибка! Данные в отчёте изменены.");
        }
    }
}

