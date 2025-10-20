package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NumberComparerTest {
    @Test
    void compareNumbers_firstGreater() {
        assertEquals(1, NumberComparer.compareNumbers(5, 3));
    }

    @Test
    void compareNumbers_secondGreater() {
        assertEquals(-1, NumberComparer.compareNumbers(2, 4));
    }

    @Test
    void compareNumbers_equal() {
        assertEquals(0, NumberComparer.compareNumbers(7, 7));
    }
}