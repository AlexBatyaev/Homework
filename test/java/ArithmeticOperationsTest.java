package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArithmeticOperationsTest {
    @Test
    void add_positiveNumbers() {
        assertEquals(5, ArithmeticOperations.add(2, 3));
    }

    @Test
    void subtract_positiveNumbers() {
        assertEquals(1, ArithmeticOperations.subtract(4, 3));
    }

    @Test
    void multiply_positiveNumbers() {
        assertEquals(12, ArithmeticOperations.multiply(3, 4));
    }

    @Test
    void divide_positiveNumbers() {
        assertEquals(2.0, ArithmeticOperations.divide(6, 3));
    }

    @Test
    void divide_byZero_throwsException() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> ArithmeticOperations.divide(5, 0));
        assertEquals("Деление на ноль!", exception.getMessage());
    }
}