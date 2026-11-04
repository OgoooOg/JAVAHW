package ru.aston.homework3.strategy;

import java.util.Map;
import java.util.HashMap;

public class ECU {
    private final Map<DriveMode, DriveModeStrategy> strategies = new HashMap<>();
    private DriveModeStrategy currentStrategy;

    public ECU() {
        strategies.put(DriveMode.ECO, new EcoMode());
        strategies.put(DriveMode.SPORT, new SportMode());
    }

    public void setMode(DriveMode mode) {
        this.currentStrategy = strategies.get(mode);
        System.out.println("ЭБУ переключен на режим: " + mode);
    }

    public void drive() {
        if (currentStrategy != null) {
            currentStrategy.drive();
        } else {
            System.out.println("Режим не выбран!");
        }
    }
}