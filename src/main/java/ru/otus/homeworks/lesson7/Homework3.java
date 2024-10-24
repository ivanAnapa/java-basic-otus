package ru.otus.homeworks.lesson7;

import java.util.Random;

public class Homework3 {
    public static void main(String[] args) {
        // 1
        int[][] array2dForTask1 = {
                {11, -2, 3, 0, 1, -4},
                {7, 5, -8, -1, 9, -2}
        };
        int sumOfPositive = sumOfPositiveElements(array2dForTask1);
        System.out.println("Сумма положительных чисел в массиве: " + sumOfPositive);

        // 2
        Random random = new Random();
        int size = random.nextInt(7) + 3;
        printSquare(size);

        // 3
        int[][] array2dForTask3 =
                {
                        {1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1}
                };
        setZeroToArrayDiagonals(array2dForTask3);

        // 4
        int[][] array2dForTask4 =
                {
                        {1, 0, 7, 3, 2},
                        {6, 1, 2, 7, 4},
                        {3, 1, 9, 8, 4}
                };
        System.out.println("Максимальное значение в массиве: " + findMax(array2dForTask4));

        // 5.
        System.out.println("Сумма: " + calculateArraySecondRowSum(new int[][]{{11, -2, 3, 0}, {7, 5, 5}}));
        System.out.println("Сумма: " + calculateArraySecondRowSum(new int[][]{{1, 2, 3}}));
    }

    /**
     * 1. Реализовать метод sumOfPositiveElements(..), принимающий в качестве аргумента целочисленный двумерный массив,
     * метод должен посчитать и вернуть сумму всех элементов массива, которые больше 0;
     */
    private static int sumOfPositiveElements(int[][] arr) {
        System.out.println("\nЗадача 1");
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int k = 0; k < arr[i].length; k++) {
                if (arr[i][k] > 0) {
                    result += arr[i][k];
                }
            }
        }
        return result;
    }

    /**
     * 2. Реализовать метод, который принимает в качестве аргумента int size и печатает в консоль квадрат
     * из символов * со сторонами соответствующей длины;
     */
    private static void printSquare(int size) {
        System.out.println("\nЗадача 2");
        System.out.println("Значение size = " + size);
        String[][] square = new String[size][size];
        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size; k++) {
                if ((i == 0 || i == (size - 1)) || (k == 0 || k == (size - 1))) {
                    square[i][k] = "*";
                } else {
                    square[i][k] = " ";
                }
                System.out.print(square[i][k]);
            }
            System.out.println();
        }
    }

    /**
     * 3. Реализовать метод, принимающий в качестве аргумента двумерный целочисленный массив, и зануляющий его
     * диагональные элементы (можете выбрать любую из диагоналей, или занулить обе);
     */
    private static void setZeroToArrayDiagonals(int[][] array2d) {
        System.out.println("\nЗадача 3");
        for (int i = 0; i < array2d.length; i++) {
            for (int j = 0; j < array2d[i].length; j++) {
                if (i == j || (i + j == array2d[i].length - 1)) {
                    array2d[i][j] = 0;
                }
                System.out.print(array2d[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 4. Реализовать метод findMax(int[][] array) который должен найти и вернуть максимальный элемент массива;
     */
    private static int findMax(int[][] array) {
        System.out.println("\nЗадача 4");
        int max = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (max < array[i][j]) {
                    max = array[i][j];
                }
            }
        }
        return max;
    }

    /**
     * 5. Реализуйте метод, который считает сумму элементов второй строки двумерного массива, если второй строки
     * не существует, то в качестве результата необходимо вернуть -1
     */
    private static int calculateArraySecondRowSum(int[][] array) {
        System.out.println("\nЗадача 5");
        if (array.length > 1) {
            int secondRowSum = array[1][0];
            for (int i = 1; i < array[1].length; i++) {
                secondRowSum += array[1][i];
            }
            return secondRowSum;
        } else {
            return -1;
        }
    }
}
