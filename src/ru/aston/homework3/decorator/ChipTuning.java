package ru.aston.homework3.decorator;

public class ChipTuning extends TuningDecorator {
    private static final int POWER_BOOST = 30;

    public ChipTuning(Engine engine) {
        super(engine);
    }

    @Override
    public int getHorsepower() {
        System.out.println("Тюнинг: Чип-тюнинг (+" + POWER_BOOST + " л.с.)");
        return super.getHorsepower() + POWER_BOOST;
    }
}