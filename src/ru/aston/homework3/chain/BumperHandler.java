package ru.aston.homework3.chain;

public class BumperHandler extends CrashSafetyHandler {
    private static final int ABSORBED_FORCE = 20;

    @Override
    protected int absorbImpact(int force) {
        System.out.println("Удар в бампер! Поглощено " + ABSORBED_FORCE + " единиц силы.");
        return Math.max(0, force - ABSORBED_FORCE);
    }
}