public class ArrayProcessor {

    public static int processArray(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        // 1. Проверка размера массива
        if (arr.length != 4 || arr[0].length != 4) {
            throw new MyArraySizeException("Неверный размер массива.  Ожидается 4x4, получено " + arr.length + "x" + arr[0].length);
        }

        int sum = 0;

        // 2. Итерация по элементам и суммирование
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]); // Преобразование в int и суммирование
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неверные данные в ячейке [" + i + "][" + j + "]: " + arr[i][j]);
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        // Пример 1: Корректный массив
        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int sum = processArray(correctArray);
            System.out.println("Сумма элементов массива: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }

        // Пример 2: Массив неверного размера
        String[][] wrongSizeArray = {
                {"1", "2"},
                {"3", "4"}
        };

        try {
            int sum = processArray(wrongSizeArray);
            System.out.println("Сумма элементов массива: " + sum); // Это не должно выполниться
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }

        // Пример 3: Массив с неверными данными
        String[][] invalidDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "abc", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int sum = processArray(invalidDataArray);
            System.out.println("Сумма элементов массива: " + sum); // Это не должно выполниться
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }

        // ArrayIndexOutOfBoundsException пример
        int[] numbers = {1, 2, 3};
        try {
            System.out.println(numbers[5]); // Попытка доступа к несуществующему индексу
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Исключение ArrayIndexOutOfBoundsException: попытка доступа к несуществующему индексу.");
        }

        System.out.println("Программа завершена.");
    }
}