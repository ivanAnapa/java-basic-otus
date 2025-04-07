package ru.otus.homeworks.lesson15;

/**
 * Реализуйте метод, аргументом которого является двумерный строковый массив размером 4х4.
 * Если передан массив другого размера необходимо бросить исключение AppArraySizeException.
 * Метод должен обойти все элементы массива, преобразовать в int и просуммировать.
 * Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит текст вместо числа),
 * должно быть брошено исключение AppArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
 * В методе main() необходимо вызвать полученный метод, обработать возможные исключения
 * AppArraySizeException и AppArrayDataException и вывести результат расчета (сумму элементов,
 * при условии что подали на вход корректный массив).
 */
public class MyApp {
    public static void main(String[] args) {

        // ******************************* Проверки размера массива *******************************
        // Первый размер массива < 4
        String[][] firstArrSizeLessThan4 = {
                {"", "", "", ""},
                {"", "", "", ""}
        };
        try {
            convertAndSumArray(firstArrSizeLessThan4);
        } catch (AppArraySizeException e) {
            e.printStackTrace();
        }

        // Первый размер массива > 4
        String[][] firstArrSizeMoreThan4 = {
                {"", "", "", ""},
                {"", "", "", ""},
                {"", "", "", ""},
                {"", "", "", ""},
                {"", "", "", ""}
        };
        try {
            convertAndSumArray(firstArrSizeMoreThan4);
        } catch (AppArraySizeException e) {
            e.printStackTrace();
        }

        // Второй размер массива меньше 4
        String[][] secondArrSizeLessThan4 = {
                {"", "", ""},
                {"", "", ""},
                {"", "", ""},
                {"", "", ""}
        };
        try {
            convertAndSumArray(secondArrSizeLessThan4);
        } catch (AppArraySizeException e) {
            e.printStackTrace();
        }

        // Второй размер массива больше 4
        String[][] secondArrSizeMoreThan4 = {
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""}
        };
        try {
            convertAndSumArray(secondArrSizeMoreThan4);
        } catch (AppArraySizeException e) {
            e.printStackTrace();
        }

        // 1 из значений не получится конвертировать в int
        String[][] arrayWithInvalidData = {
                {"1", "1", "1", "1"},
                {"2", "2", "2", "2"},
                {"3", "3", "3", "3"},
                {"4", "4", "4", "A"}
        };
        try {
            convertAndSumArray(arrayWithInvalidData);
        } catch (AppArrayDataException e) {
            e.printStackTrace();
        }

        // Валидные значения
        String[][] arrayWithValidData = {
                {"1", "1", "1", "1"},
                {"2", "2", "2", "2"},
                {"3", "3", "3", "3"},
                {"4", "4", "4", "4"}
                // 4 + 8 + 12 + 16 = 40
        };
        try {
            convertAndSumArray(arrayWithValidData);
        } catch (AppArrayDataException e) {
            e.printStackTrace();
        }

    }

    public static void convertAndSumArray(String[][] array) {
        // Вынес проверку размеров массива в отдельный приватный метод
        checkArraySize(array);
        System.out.println("\nРазмеры массива в норме, проверяем содержимое:");
        int arraySum = 0;
        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array[i].length; j++) {
                try {
                    arraySum = arraySum + Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new AppArrayDataException("В ячейке [" + i + "][" + j + "] недопустимое значение: " + array[i][j]);
                }
            }
        }
        System.out.println("Сумма чисел в массиве: " + arraySum);

    }

    private static void checkArraySize(String[][] array) {
        if (array.length != 4) {
            throw new AppArraySizeException("Первый размер массива не равен 4");
        }
        for (String[] strings : array) {
            int secondArrSize = 0;
            for (int k = 0; k < strings.length; k++) {
                secondArrSize++;
                if (secondArrSize > 4) {
                    throw new AppArraySizeException("Второй размер массива больше 4");
                }
            }
            if (secondArrSize < 4) {
                throw new AppArraySizeException("Второй размер массива меньше 4");
            }
        }
    }
}
