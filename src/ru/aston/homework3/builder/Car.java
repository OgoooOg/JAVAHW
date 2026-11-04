package ru.aston.homework3.builder;

public class Car {
    private final BodyType bodyType;
    private final String engine;
    private final String color;

    private Car(Builder builder) {
        this.bodyType = builder.bodyType;
        this.engine = builder.engine;
        this.color = builder.color;
    }

    public static Builder builder() {
        return new Builder();
    }

    public void showSpecs() {
        System.out.println("Автомобиль собран: Кузов [" + bodyType + "], Двигатель [" + engine + "], Цвет [" + color + "]");
    }

    public static class Builder {
        private BodyType bodyType = BodyType.SEDAN;
        private String engine = "V4 1.6L";
        private String color = "Белый";

        public Builder bodyType(BodyType bodyType) {
            this.bodyType = bodyType;
            return this;
        }

        public Builder engine(String engine) {
            this.engine = engine;
            return this;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}