package ru.aston.homework1;

import java.util.Objects;

public class Car {
    private String color;

    public Car(String color) {
        this.color = color;
    }

    public Car(Car other) {
        if (other != null) {
            this.color = other.color;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(color, car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(color);
    }

    @Override
    public String toString() {
        return "Car{color='" + color + "'}";
    }
}

