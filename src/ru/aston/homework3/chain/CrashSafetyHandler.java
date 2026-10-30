package ru.aston.homework3.chain;

public abstract class CrashSafetyHandler {
    protected CrashSafetyHandler nextHandler;
    public void setNext(CrashSafetyHandler nextHandler) { this.nextHandler = nextHandler; }
    public abstract void processImpact(int force);
}
