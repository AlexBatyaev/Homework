package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleAreaTest {
    @Test
    void calculateTriangleArea_validInput() {
        assertEquals(10.0, new TriangleArea().calculateArea(5, 4));
    }

    @Test
    void calculateTriangleArea_zeroBase_throwsException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new TriangleArea().calculateArea(0, 5));
        assertEquals("Основание и высота должны быть положительными.", exception.getMessage());
    }

    @Test
    void calculateTriangleArea_negativeHeight_throwsException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new TriangleArea().calculateArea(5, -1));
        assertEquals("Основание и высота должны быть положительными.", exception.getMessage());
    }
}