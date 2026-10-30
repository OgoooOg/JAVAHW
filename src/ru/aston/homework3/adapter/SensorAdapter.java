package ru.aston.homework3.adapter;

public class SensorAdapter implements ModernDigitalGauge {
    private LegacyMechanicalSensor mechanicalSensor;
    public SensorAdapter(LegacyMechanicalSensor sensor) { this.mechanicalSensor = sensor; }
    @Override
    public void showRPM() {
        double hz = mechanicalSensor.getRotationFrequencyHz();
        int rpm = (int) (hz * 60);
        System.out.println("[Цифровой экран]: " + rpm + " RPM.");
    }
}
