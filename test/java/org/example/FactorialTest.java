package org.example;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class FactorialTest {
    @Test
    public void calculateFactorial_positiveNumber() {
        Factorial factorial = new Factorial();
        assertEquals(factorial.calculateFactorial(5), 120);
    }

    @Test
    public void calculateFactorial_zero() {
        Factorial factorial = new Factorial();
        assertEquals(factorial.calculateFactorial(0), 1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void calculateFactorial_negativeNumber_throwsException() {
        Factorial factorial = new Factorial();
        factorial.calculateFactorial(-1);
    }
}