package ru.aston.homework3.decorator;

public class TurboCharger extends TuningDecorator {
    private static final int POWER_BOOST = 80;

    public TurboCharger(Engine engine) {
        super(engine);
    }

    @Override
    public int getHorsepower() {
        System.out.println("Тюнинг: Установлен Турбонаддув (+" + POWER_BOOST + " л.с.)");
        return super.getHorsepower() + POWER_BOOST;
    }
}