package org.example;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class TriangleAreaTest {
    @Test
    public void calculateArea_validTriangle() {
        TriangleArea triangleArea = new TriangleArea();
        assertEquals(triangleArea.calculateArea(3.0, 4.0), 6.0, 0.001);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void calculateArea_invalidInput_negativeBase() {
        TriangleArea triangleArea = new TriangleArea();
        triangleArea.calculateArea(-3.0, 4.0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void calculateArea_invalidInput_negativeHeight() {
        TriangleArea triangleArea = new TriangleArea();
        triangleArea.calculateArea(3.0, -4.0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void calculateArea_invalidInput_zeroBase() {
        TriangleArea triangleArea = new TriangleArea();
        triangleArea.calculateArea(0.0, 4.0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void calculateArea_invalidInput_zeroHeight() {
        TriangleArea triangleArea = new TriangleArea();
        triangleArea.calculateArea(3.0, 0.0);
    }
}