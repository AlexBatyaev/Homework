package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {
    private Factorial factorial;

    @BeforeEach
    void setUp() {
        factorial = new Factorial();
    }

    @Test
    void calculateFactorial_positiveNumber() {
        assertEquals(120, factorial.calculateFactorial(5));
    }

    @Test
     void calculateFactorial_zero() {
        assertEquals(1, factorial.calculateFactorial(0));
    }

    @Test
    void calculateFactorial_negativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> factorial.calculateFactorial(-1));
    }
}