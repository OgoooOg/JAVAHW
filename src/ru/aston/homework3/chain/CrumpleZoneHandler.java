package ru.aston.homework3.chain;

public class CrumpleZoneHandler extends CrashSafetyHandler {
    private static final int ABSORBED_FORCE = 50;

    @Override
    protected int absorbImpact(int force) {
        System.out.println("Зоны деформации кузова сминаются! Поглощено " + ABSORBED_FORCE + " единиц силы.");
        int remaining = Math.max(0, force - ABSORBED_FORCE);
        if (remaining > 0) {
            System.out.println("Подушки сработали! Урон водителя: " + remaining + " HP.");
        } else {
            System.out.println("Водитель цел и невредим.");
        }
        return remaining;
    }
}