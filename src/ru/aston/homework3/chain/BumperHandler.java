package ru.aston.homework3.chain;

public class BumperHandler extends CrashSafetyHandler {
    @Override
    public void processImpact(int force) {
        System.out.println("Удар в бампер! Поглощено 20 единиц силы.");
        int remainingForce = Math.max(0, force - 20);
        if (remainingForce > 0 && nextHandler != null) { nextHandler.processImpact(remainingForce); }
    }
}
