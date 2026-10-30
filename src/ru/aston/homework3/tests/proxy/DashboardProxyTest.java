package ru.aston.homework3.tests.proxy;
import org.junit.jupiter.api.Test;
import ru.aston.homework3.proxy.*;
import static org.junit.jupiter.api.Assertions.*;
public class DashboardProxyTest {
    @Test public void testProxy() {
        DashboardDisplay proxyDashboard = new ProxyDashboardDisplay("GT-R");
        assertDoesNotThrow(proxyDashboard::render);
    }
}
