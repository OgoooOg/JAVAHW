package ru.aston.homework3;

import ru.aston.homework3.builder.*;
import ru.aston.homework3.strategy.*;
import ru.aston.homework3.decorator.*;
import ru.aston.homework3.proxy.*;
import ru.aston.homework3.chain.*;
import ru.aston.homework3.adapter.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("===ГОНОЧНЫЙ СИМУЛЯТОР (ДЗ №3 - ПАТТЕРНЫ) ===\n");

        System.out.println("--- 1. Сборка автомобиля (Builder) ---");
        Car customCar = Car.builder()
                .bodyType(BodyType.COUPE)
                .engine("V8")
                .color("Красный")
                .build();
        customCar.showSpecs();
        System.out.println();

        System.out.println("--- 2. Управление ЭБУ (Strategy) ---");
        ECU ecu = new ECU();
        ecu.setMode(DriveMode.ECO);
        ecu.drive();
        ecu.setMode(DriveMode.SPORT);
        ecu.drive();
        System.out.println();

        System.out.println("--- 3. Тюнинг двигателя (Decorator) ---");
        Engine stockEngine = new StockEngine();
        System.out.println("Стоковая мощность: " + stockEngine.getHorsepower() + " л.с.");

        Engine tunedEngine = new TurboCharger(new ChipTuning(new StockEngine()));
        System.out.println("Итоговая мощность: " + tunedEngine.getHorsepower() + " л.с.");
        System.out.println();

        System.out.println("--- 4. Переключение камеры в салон (Proxy) ---");
        DashboardDisplay dashboard = new ProxyDashboardDisplay("GT-R");
        System.out.println("Камера снаружи. Текстуры еще не загружены.");
        System.out.println("Переключаем камеру в салон...");
        dashboard.render();
        System.out.println();

        System.out.println("--- 5. Тест аварии (Chain of Responsibility) ---");
        CrashSafetyHandler bumper = new BumperHandler();
        CrashSafetyHandler crumpleZone = new CrumpleZoneHandler();
        bumper.setNext(crumpleZone);
        System.out.println("Удар силой 80 единиц!");
        bumper.processImpact(80);
        System.out.println();

        System.out.println("--- 6. Подключение старого датчика (Adapter) ---");
        ModernDigitalGauge digitalDashboard = new SensorAdapter(new LegacyMechanicalSensor());
        digitalDashboard.showRPM();
    }
}