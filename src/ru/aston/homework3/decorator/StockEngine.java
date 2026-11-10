package ru.aston.homework3.decorator;

public class StockEngine implements Engine {
    private static final int BASE_POWER = 150;

    @Override
    public int getHorsepower() {
        return BASE_POWER;
    }
}