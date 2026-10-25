package ru.aston.homework3.tests.adapter;
import org.junit.jupiter.api.Test;
import ru.aston.homework3.adapter.*;
import static org.junit.jupiter.api.Assertions.*;
public class SensorAdapterTest {
    @Test public void testAdapter() {
        LegacyMechanicalSensor oldSensor = new LegacyMechanicalSensor();
        SensorAdapter adapter = new SensorAdapter(oldSensor);
        assertDoesNotThrow(adapter::showRPM);
    }
}
