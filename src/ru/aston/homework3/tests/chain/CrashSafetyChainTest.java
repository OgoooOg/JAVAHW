package ru.aston.homework3.tests.chain;
import org.junit.jupiter.api.Test;
import ru.aston.homework3.chain.*;
import static org.junit.jupiter.api.Assertions.*;
public class CrashSafetyChainTest {
    @Test public void testChain() {
        CrashSafetyHandler bumper = new BumperHandler();
        CrashSafetyHandler crumpleZone = new CrumpleZoneHandler();
        bumper.setNext(crumpleZone);
        assertDoesNotThrow(() -> bumper.processImpact(80));
    }
}
