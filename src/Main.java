/* Домашнее задание Модуля 1. Реализовать свой иммутабельный класс, который будет внутри себя содержать
поле с изменяемым классом */

/* Условно продаются машины и нужно, чтобы отчет о продаже CarSale был неизменяемым
(в нем записано: имя покупателя и какая машина была продана).
 Класс машины Car изменяем (ее можно перекрасить и тп.). Нужно, чтобы даже если купленную машину потом перекрасят,
в архивном отчете о продаже цвет навсегда оставался первоначальным */

//Изменяемый класс — Машина
class Car {
    private String color;

    public Car(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

// Неизменяемый (иммутабельный) класс — Отчет о продаже
final class CarSale {
    private final String buyerName;
    private final Car car;

    public CarSale(String buyerName, Car car) {
        this.buyerName = buyerName;
        this.car = new Car(car.getColor());
    }

    public String getBuyerName() {
        return buyerName;
    }

    public Car getCar() {
        return new Car(car.getColor());
    }
}

// Проверка
public class Main {
    public static void main(String[] args) {
        //Создаем изменяемую машину (изначально она Черная)
        Car myCar = new Car("Черный");

        //Оформляем неизменяемый отчет о продаже для Олежи
        CarSale saleRecord = new CarSale("Олежа", myCar);

        System.out.println("Проверка 1: Красим исходную машину ");
        System.out.println("Цвет машины в отчете Изначально: " + saleRecord.getCar().getColor());

        // Олежа поехал в автосервис и перекрасил свою машину в Красный
        myCar.setColor("Красный");

        // Проверка поменялся ли цвет в архиве
        System.out.println("Цвет машины в отчете ПОСЛЕ перекраски: " + saleRecord.getCar().getColor());
        System.out.println("(Успех: в отчете остался Черный цвет, так как архив защищен копированием!)");


        System.out.println("\n Проверка 2: Пытаемся взломать отчет через геттер ");
        // Через геттер попытка перекрасить в Зеленый
        Car stolenCar = saleRecord.getCar();
        stolenCar.setColor("Зеленый");

        // Цвет прежний
        System.out.println("Цвет машины в отчете ПОСЛЕ попытки взлома: " + saleRecord.getCar().getColor());
    }
}
