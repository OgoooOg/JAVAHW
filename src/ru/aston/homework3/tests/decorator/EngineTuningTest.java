package ru.aston.homework3.tests.decorator;
import org.junit.jupiter.api.Test;
import ru.aston.homework3.decorator.*;
import static org.junit.jupiter.api.Assertions.*;
public class EngineTuningTest {
    @Test public void testTurboCharger() {
        Engine stock = new StockEngine();
        Engine tuned = new TurboCharger(stock);
        assertEquals(230, tuned.getHorsepower());
    }
}
