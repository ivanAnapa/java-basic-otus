package ru.otus.homeworks.lesson5;

import java.util.Arrays;

public class Homework2WithAsterisks {
    public static void main(String[] args) {

        // *1
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {2, 2};
        int[] arr3 = {1, 1, 1, 1, 1};
        // Ожидание: { 4, 5, 4, 1, 1 }
        sumArraysAndPrintResult(arr1, arr2, arr3);

        // *2
        // int[] arrayForExercise2 = { 1, 1, 1, 1, 1,  5 };
        // int[] arrayForExercise2 = { 5, 3, 4, -2 };
        // int[] arrayForExercise2 = { 7, 2, 2, 2 };
        int[] arrayForExercise2 = {9, 4};
        checkArrays(arrayForExercise2);

        // *3
        // int[] arrayForExercise3 = { 1, 2, 3, 4, 5,  6 };
        int[] arrayForExercise3 = {3, 2, 1};
        checkArraySorting(true, 1, 2, 3);
        checkArraySorting(false, 3, 2, 1);
        checkArraySorting(true, 3, 2, 1);

        // *4
        reverseArray(1, 2, 3, 4);
    }

    /* *1
    Реализуйте метод, принимающий на вход набор целочисленных массивов, и получающий новый
    массив равный сумме входящих;
    Пример:
    { 1, 2, 3 }
  + { 2, 2 }
  + { 1, 1, 1, 1, 1}
  = { 4, 5, 4, 1, 1 }
     */
    private static void sumArraysAndPrintResult(int[] arr1, int[] arr2, int[] arr3) {
        // Поиск размера самого большого массива из переданных в метод
        int maxArrayLength = Math.max(arr1.length, Math.max(arr2.length, arr3.length));
        // Создание нового массива с длиной, равной самому большому
        int[] resultArray = new int[maxArrayLength];
        for (int i = 0; i < arr1.length; i++) {
            resultArray[i] += arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            resultArray[i] += arr2[i];
        }
        for (int i = 0; i < arr3.length; i++) {
            resultArray[i] += arr3[i];
        }
        System.out.println("Итоговый массив: " + Arrays.toString(resultArray));
    }

    /* *2
    Реализуйте метод, проверяющий что есть “точка” в массиве, в которой сумма левой и правой части равны.
    “Точка находится между элементами”;
    Пример: { 1, 1, 1, 1, 1, | 5 }, { 5, | 3, 4, -2 }, { 7, 2, 2, 2 }, { 9, 4 }
     */
    private static void checkArrays(int... arr) {
        boolean isPointExist = false;
        int indexOfPoint = 0;
        int sumLeft = 0;
        for (int i = 0; i < arr.length; i++) {
            int sumRight = 0;
            sumLeft += arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                sumRight += arr[j];
            }
            if (sumLeft == sumRight) {
                isPointExist = true;
                indexOfPoint = i;
                break;
            }
        }
        if (isPointExist) {
            System.out.println("\nТочка находится между элементами " + (indexOfPoint + 1) + " и " + (indexOfPoint + 2));
        } else {
            System.out.println("\nТочки в массиве нет");
        }
        System.out.println(); // Искусственный разрыв в конце метода
    }

    /* *3
     Реализуйте метод, проверяющий что все элементы массива идут в порядке убывания или возрастания (по выбору пользователя)
     */
    private static void checkArraySorting(boolean isSortedAsc, int... arr) {
        boolean sortedAsExpected = false;
        if (isSortedAsc) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] < arr[i + 1]) {
                    sortedAsExpected = true;
                } else {
                    sortedAsExpected = false;
                    break;
                }
            }
            if (sortedAsExpected) {
                System.out.println("Массив отсортирован в порядке возрастания");
            } else {
                System.out.println("Сортировка массива не соответствует ожидаемой");
            }
        } else {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    sortedAsExpected = true;
                } else {
                    sortedAsExpected = false;
                    break;
                }
            }
            if (sortedAsExpected) {
                System.out.println("Массив отсортирован в порядке убывания");
            } else {
                System.out.println("Сортировка массива не соответствует ожидаемой");
            }
        }
    }

    /* *4
    Реализуйте метод, “переворачивающий” входящий массив
    Пример: { 1 2 3 4 } => { 4 3 2 1 }
     */
    private static void reverseArray(int... arr) {
        System.out.println("\nМассив на входе: " + Arrays.toString(arr));
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[(arr.length - 1) - i] = arr[i];
        }
        System.out.println("Массив на выходе: " + Arrays.toString(result));
    }

}
