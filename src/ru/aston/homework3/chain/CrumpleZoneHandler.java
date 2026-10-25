package ru.aston.homework3.chain;

public class CrumpleZoneHandler extends CrashSafetyHandler {
    @Override
    public void processImpact(int force) {
        System.out.println("Зоны деформации кузова сминаются! Поглощено 50 единиц силы.");
        int remainingForce = Math.max(0, force - 50);
        if (remainingForce > 0) { System.out.println("Подушки сработали! Урон водителя: " + remainingForce + " HP."); }
        else { System.out.println("Водитель цел и невредим."); }
    }
}
