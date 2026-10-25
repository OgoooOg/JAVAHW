package ru.aston.homework3.strategy;

public class SportMode implements DriveModeStrategy {
    @Override
    public void drive() { System.out.println("Режим SPORT: Максимальные обороты двигателя!"); }
}
