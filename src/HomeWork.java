public class HomeWork {

    public static void main(String[] args) {
        // 1. Напечатать три слова в столбик
        printThreeWords();

        // 2. Проверить знак суммы двух чисел
        checkSumSign();

        // 3. Определить, какой цвет соответствует заданному значению
        printColor();

        // 4. Сравнить два числа
        compareNumbers();

        // 5. Проверить, что сумма двух чисел лежит в диапазоне от 10 до 20
        System.out.println("Сумма в диапазоне 10-20: " + isSumBetween10And20(5, 12));

        // 6. Напечатать, является ли число положительным или отрицательным
        printPositiveOrNegative(0);

        // 7. Определить, является ли число отрицательным
        System.out.println("Число отрицательное? " + isNegative(-5));

        // 8. Напечатать строку несколько раз
        printStringMultipleTimes("Hello", 3);

        // 9. Определить, является ли год високосным
        System.out.println("Является ли год 2024 високосным? " + isLeapYear(2024));

        // 10. Инвертировать элементы массива (0 заменить на 1, 1 заменить на 0)
        

        // 11. Заполнить массив числами от 1 до 100
        int[] array11 = new int[100];
        fillArrayWithNumbers(array11);
        System.out.print("Массив заполненный числами от 1 до 100: ");
        printArray(array11);

        // 12. Умножить элементы массива, меньшие 6, на 2
        int[] array12 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.print("Массив до умножения: ");
        printArray(array12);
        multiplyLessThan6(array12);
        System.out.print("Массив после умножения: ");
        printArray(array12);

        // 13. Заполнить диагонали двумерного массива единицами
        int[][] array13 = new int[5][5];
        fillDiagonalWithOnes(array13);
        System.out.println("Двумерный массив с диагоналями единицами:");
        print2DArray(array13);

        // 14. Создать массив заданной длины и заполнить его заданным значением
        System.out.print("Массив заданной длинны и заполненный одинаковым значением: ");
        int[] array14 = createArray(5, 10);
        printArray(array14);
    }

    // 1.
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    // 2.
    public static void checkSumSign() {
        int a = -5;
        int b = 10;
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    // 3.
    public static void printColor() {
        int value = 101;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    // 4.
    public static void compareNumbers() {
        int a = 5;
        int b = 10;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    // 5.
    public static boolean isSumBetween10And20(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    // 6.
    public static void printPositiveOrNegative(int number) {
        if (number >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    // 7.
    public static boolean isNegative(int number) {
        return number < 0;
    }

    // 8.
    public static void printStringMultipleTimes(String str, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(str);
        }
    }

    // 9.
    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else return year % 4 == 0;
    }

    // 10.
    
    public static void invertArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] == 0) ? 1 : 0;
        }
    }

    // 11.
    public static void fillArrayWithNumbers(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = i + 1;
    }

    // 12.
    public static void multiplyLessThan6(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
    }

    // 13.
    public static void fillDiagonalWithOnes(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 1;
            arr[i][arr.length - 1 - i] = 1;
        }
    }

    // 14.
    public static int[] createArray(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }

    // Вспомогательный метод для вывода массива в консоль
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // Вспомогательный метод для вывода двумерного массива в консоль
    public static void print2DArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
                if (j < arr[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }
}
