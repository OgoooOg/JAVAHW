package ru.aston.homework3.adapter;

public class SensorAdapter implements ModernDigitalGauge {
    private static final int SECONDS_IN_MINUTE = 60;
    private final LegacyMechanicalSensor mechanicalSensor;

    public SensorAdapter(LegacyMechanicalSensor sensor) {
        this.mechanicalSensor = sensor;
    }

    @Override
    public void showRPM() {
        double hz = mechanicalSensor.getRotationFrequencyHz();
        int rpm = (int) Math.round(hz * SECONDS_IN_MINUTE);
        System.out.println("[Цифровой экран]: " + rpm + " RPM.");
    }
}