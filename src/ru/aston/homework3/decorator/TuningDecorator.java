package ru.aston.homework3.decorator;

public abstract class TuningDecorator implements Engine {
    protected Engine baseEngine;
    public TuningDecorator(Engine engine) { this.baseEngine = engine; }
    @Override
    public int getHorsepower() { return baseEngine.getHorsepower(); }
}
