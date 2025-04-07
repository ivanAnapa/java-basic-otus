package ru.otus.homeworks.lesson5;

import java.util.Arrays;
import java.util.Random;

public class Homework2 {
    public static void main(String[] args) {
        Random random = new Random();
        int randomSize = random.nextInt(15 - 5) + 5; // диапазон от 5 до 9 включительно

        // 1
        printRowNumberOfTimes(randomSize, "Привет из солнечной Анапы!");

        // 2
        printSumOfElementsWithValuesMoreThanFive(1, 2, 5, 7, 8, 44, 12, 3);

        // 3
        int[] arrayForExercise3 = new int[randomSize];
        fillArray(5, arrayForExercise3);

        // 4
        int[] arrayForExercise4 = {1, 2, 5, 7, 9, 5, 6, 4};
        increaseArray(2, arrayForExercise4);

        // 5
        // int[] arrayForExercise5 = {2, 2, 2, 2, 2, 2};
        // int[] arrayForExercise5 = {2, 1, 2, 2, 2, 2};
        int[] arrayForExercise5 = {2, 2, 2, 2, 1, 2};
        printSumOfGreaterHalfOfArray(arrayForExercise5);
    }

    /* 1
    Реализуйте метод, принимающий в качестве аргументов целое число и строку, и печатающий в консоль строку
    указанное количество раз
     */
    private static void printRowNumberOfTimes(int count, String textForPrint) {
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + textForPrint);
        }
    }

    /* 2
    Реализуйте метод, принимающий в качестве аргумента целочисленный массив, суммирующий все элементы,
    значение которых больше 5, и печатающий полученную сумму в консоль.
     */
    private static void printSumOfElementsWithValuesMoreThanFive(int... arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 5) {
                sum += arr[i];
            }
        }
        System.out.println("\nСумма элементов со значением > 5 равна: " + sum);
    }

    /* 3
    Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на целочисленный массив,
    метод должен заполниться каждую ячейку массива указанным числом.
     */
    private static void fillArray(int numberForFilling, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = numberForFilling;
        }
        System.out.println("\nЗаполненный массив: " + Arrays.toString(arr));
    }

    /* 4
    Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на целочисленный массив,
    увеличивающий каждый элемент которого на указанное число.
    */
    private static void increaseArray(int numberForIncrease, int[] arr) {
        System.out.println("\nМассив на входе: " + Arrays.toString(arr));
        System.out.println("Число, на которое следует увеличить значения в массиве: " + numberForIncrease);
        for (int i = 0; i < arr.length; i++) {
            arr[i] += numberForIncrease;
        }
        System.out.println("Массив на выходе: " + Arrays.toString(arr));
    }

    /* 5
    Реализуйте метод, принимающий в качестве аргумента целочисленный массив, и печатающий в консоль
    сумма элементов какой из половин массива больше.
     */
    private static void printSumOfGreaterHalfOfArray(int... arr) {
        int sumOfLeft = 0;
        int sumOfRight = 0;
        for (int i = 0; i < arr.length / 2; i++) {
            sumOfLeft += arr[i];
        }
        for (int i = arr.length - 1; i >= arr.length / 2; i--) {
            sumOfRight += arr[i];
        }
        if (sumOfLeft > sumOfRight) {
            System.out.println("\nЛевая половина массива больше");
        } else if (sumOfRight > sumOfLeft) {
            System.out.println("\nПравая половина массива больше");
        } else {
            System.out.println("\nЛевая половина массива равна правой");
        }
    }


}
    /*
    Заметки с лекции для истории
    // ctrl + alt + m (создать метод из выделенного кода)

        int n = 3;
        int m = n++ + ++n; // 3 + 5 = 8
        System.out.println(m);

        int[] arr1 = new int[10];
        int[] arr2 = new int[12];
        Math.min(arr1.length, arr2.length); // Найти из 2 массивов самый короткий
        System.out.println(Arrays.toString(arr1)); // Печать массива
     */
