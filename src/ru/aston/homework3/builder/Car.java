package ru.aston.homework3.builder;

public class Car {
    private final String bodyType;
    private final String engine;
    private final String color;

    private Car(Builder builder) {
        this.bodyType = builder.bodyType;
        this.engine = builder.engine;
        this.color = builder.color;
    }

    public void showSpecs() {
        System.out.println("Автомобиль собран: Кузов [" + bodyType + "], Двигатель [" + engine + "], Цвет [" + color + "]");
    }

    public static class Builder {
        private String bodyType = "Седан";
        private String engine = "V4 1.6L";
        private String color = "Белый";

        public Builder setBodyType(String bodyType) { this.bodyType = bodyType; return this; }
        public Builder setEngine(String engine) { this.engine = engine; return this; }
        public Builder setColor(String color) { this.color = color; return this; }
        public Car build() { return new Car(this); }
    }
}
