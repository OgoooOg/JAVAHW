package ru.aston.homework3.strategy;

public class EcoMode implements DriveModeStrategy {
    @Override
    public void drive() { System.out.println("Режим ECO: Ограничение мощности, экономия топлива."); }
}
