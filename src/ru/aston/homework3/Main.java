package ru.aston.homework3;

import ru.aston.homework3.builder.Car;
import ru.aston.homework3.strategy.*;
import ru.aston.homework3.decorator.*;
import ru.aston.homework3.proxy.*;
import ru.aston.homework3.chain.*;
import ru.aston.homework3.adapter.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== 🏎️ ГОНОЧНЫЙ СИМУЛЯТОР (ДЗ №3 - ПАТТЕРНЫ) ===\n");

        Car customCar = new Car.Builder().setBodyType("Купе").setEngine("V8").setColor("Красный").build();
        customCar.showSpecs();

        DriveModeStrategy currentMode = new EcoMode();
        currentMode.drive();
        currentMode = new SportMode();
        currentMode.drive();

        Engine myEngine = new TurboCharger(new StockEngine());
        System.out.println("Мощность: " + myEngine.getHorsepower() + " л.с.");

        DashboardDisplay dashboard = new ProxyDashboardDisplay("GT-R");
        dashboard.render();

        CrashSafetyHandler bumper = new BumperHandler();
        CrashSafetyHandler crumpleZone = new CrumpleZoneHandler();
        bumper.setNext(crumpleZone);
        bumper.processImpact(80);

        ModernDigitalGauge digitalDashboard = new SensorAdapter(new LegacyMechanicalSensor());
        digitalDashboard.showRPM();
    }
}
