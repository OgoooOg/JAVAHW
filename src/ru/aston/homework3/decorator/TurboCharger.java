package ru.aston.homework3.decorator;

public class TurboCharger extends TuningDecorator {
    public TurboCharger(Engine engine) { super(engine); }
    @Override
    public int getHorsepower() {
        System.out.println("Тюнинг: Установлен Турбонаддув (+80 л.с.)");
        return super.getHorsepower() + 80;
    }
}
