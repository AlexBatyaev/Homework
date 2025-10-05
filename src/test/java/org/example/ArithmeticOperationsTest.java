package org.example;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ArithmeticOperationsTest {
    ArithmeticOperations operations = new ArithmeticOperations();

    @Test
    public void add_positiveNumbers() {
        assertEquals(operations.add(5, 3), 8);
    }

    @Test
    public void subtract_positiveNumbers() {
        assertEquals(operations.subtract(5, 3), 2);
    }

    @Test
    public void multiply_positiveNumbers() {
        assertEquals(operations.multiply(5, 3), 15);
    }

    @Test
    public void divide_positiveNumbers() {
        assertEquals(operations.divide(6, 3), 2.0, 0.001);
    }

    @Test
    public void divide_byZero() {
        try {
            operations.divide(5, 0);
            fail("Ожидалось исключение IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Деление на ноль недопустимо");
        }
    }
}