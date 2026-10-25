package ru.aston.homework3.tests.builder;
import org.junit.jupiter.api.Test;
import ru.aston.homework3.builder.Car;
import static org.junit.jupiter.api.Assertions.*;
public class CarBuilderTest {
    @Test public void testCarBuilderCreatesCorrectObject() {
        Car car = new Car.Builder().setBodyType("Купе").build();
        assertNotNull(car);
    }
}
