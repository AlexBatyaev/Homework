package org.example;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class NumberComparisonTest {
    NumberComparison comparison = new NumberComparison();

    @Test
    public void compare_firstGreaterThanSecond() {
        assertEquals(comparison.compare(5, 3), 1);
    }

    @Test
    public void compare_firstLessThanSecond() {
        assertEquals(comparison.compare(3, 5), -1);
    }

    @Test
    public void compare_numbersAreEqual() {
        assertEquals(comparison.compare(5, 5), 0);
    }
}