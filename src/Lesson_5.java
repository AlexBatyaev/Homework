class MyArraySizeException extends Exception {
	public MyArraySizeException(String message) {
		super(message);
	}
}

class MyArrayDataException extends Exception {
	public MyArrayDataException(String message) {
		super(message);
	}
}

public class Lesson_5 {

	public static int processArray(String[][] arr) throws MyArraySizeException, MyArrayDataException {
		final int expectedSize = 4;
		if (arr.length != expectedSize) {
			throw new MyArraySizeException("Массив должен быть размером " + expectedSize + "x" + expectedSize
					+ ", но имеет размер " + arr.length + "x" + (arr.length > 0 ? arr[0].length : 0));
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i].length != expectedSize) {
				throw new MyArraySizeException("Массив должен быть размером " + expectedSize + "x" + expectedSize
						+ ", но имеет размер " + arr.length + "x" + (arr.length > 0 ? arr[0].length : 0));
			}
		}

		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				try {
					sum += Integer.parseInt(arr[i][j]);
				} catch (NumberFormatException e) {
					throw new MyArrayDataException("Неверные данные в ячейке [" + i + "][" + j + "]: " + arr[i][j]);
				}
			}
		}
		return sum;
	}

	public static void generateAndCatchArrayIndexOutOfBoundsException() {
		int[] array = new int[5];
		try {
			// Попытка доступа к элементу за пределами массива
			int value = array[10]; // Индекс 10 находится за пределами границ массива (0-4)
			System.out.println("Элемент: " + value); // Эта строка не будет выполнена
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Поймано исключение ArrayIndexOutOfBoundsException: " + e.getMessage());
		} finally {
			System.out.println("Блок finally выполнен");
		}
	}

	public static void main(String[] args) {
		String[][] validArray = { { "1", "2", "3", "4" }, { "5", "6", "7", "8" }, { "9", "10", "11", "12" },
				{ "13", "14", "15", "16" } };

		String[][] invalidSizeArray = { { "1", "2" }, { "3", "4" } };

		String[][] invalidDataArray = { { "1", "2", "3", "4" }, { "5", "6", "7", "8" }, { "9", "10", "abc", "12" },
				{ "13", "14", "15", "16" } };

		try {
			int sum = processArray(validArray);
			System.out.println("Сумма элементов validArray: " + sum);
		} catch (MyArraySizeException e) {
			System.err.println("Ошибка размера массива: " + e.getMessage());
		} catch (MyArrayDataException e) {
			System.err.println("Ошибка данных в массиве: " + e.getMessage());
		}

		try {
			int sum = processArray(invalidSizeArray);
			System.out.println("Сумма элементов invalidSizeArray: " + sum);
		} catch (MyArraySizeException e) {
			System.err.println("Ошибка размера массива: " + e.getMessage());
		} catch (MyArrayDataException e) {
			System.err.println("Ошибка данных в массиве: " + e.getMessage());
		}

		try {
			int sum = processArray(invalidDataArray);
			System.out.println("Сумма элементов invalidDataArray: " + sum);
		} catch (MyArraySizeException e) {
			System.err.println("Ошибка размера массива: " + e.getMessage());
		} catch (MyArrayDataException e) {
			System.err.println("Ошибка данных в массиве: " + e.getMessage());
		}

		System.out.println("\nДемонстрация ArrayIndexOutOfBoundsException:");
		generateAndCatchArrayIndexOutOfBoundsException();
	}
}
