package ru.aston.homework3.tests.strategy;
import org.junit.jupiter.api.Test;
import ru.aston.homework3.strategy.*;
import static org.junit.jupiter.api.Assertions.*;
public class DriveModeStrategyTest {
    @Test public void testStrategies() {
        DriveModeStrategy eco = new EcoMode();
        assertNotNull(eco);
    }
}
