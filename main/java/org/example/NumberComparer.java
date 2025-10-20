package org.example;

public class NumberComparer {
    public static int compareNumbers(int a, int b) {
        if (a > b) {
            return 1; // a больше b
        } else if (a < b) {
            return -1; // a меньше b
        } else {
            return 0; // a равно b
        }
    }
}