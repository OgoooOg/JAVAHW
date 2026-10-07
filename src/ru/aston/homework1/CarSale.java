package ru.aston.homework1;

import java.util.Objects;

public final class CarSale {
    private final String buyerName;
    private final Car car;

    public CarSale(String buyerName, Car car) {

        Objects.requireNonNull(car, "Машина в отчёте о продаже не может быть null!");
        this.buyerName = buyerName;
        this.car = new Car(car);
    }

    public String getBuyerName() {
        return buyerName;
    }

    public Car getCar() {
        return new Car(this.car);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarSale carSale = (CarSale) o;
        return Objects.equals(buyerName, carSale.buyerName) && Objects.equals(car, carSale.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buyerName, car);
    }

    @Override
    public String toString() {
        return "CarSale{buyerName='" + buyerName + "', car=" + car + "}";
    }
}
