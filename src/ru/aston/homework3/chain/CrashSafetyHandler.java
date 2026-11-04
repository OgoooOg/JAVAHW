package ru.aston.homework3.chain;

public abstract class CrashSafetyHandler {
    protected CrashSafetyHandler nextHandler;

    public void setNext(CrashSafetyHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public final void processImpact(int force) {
        int remainingForce = absorbImpact(force);
        if (remainingForce > 0 && nextHandler != null) {
            nextHandler.processImpact(remainingForce);
        } else if (remainingForce > 0) {
            System.out.println("Критический урон! Остаток силы: " + remainingForce);
        }
    }

    protected abstract int absorbImpact(int force);
}