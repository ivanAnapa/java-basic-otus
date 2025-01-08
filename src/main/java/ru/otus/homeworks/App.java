package ru.otus.homeworks;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число");
        int a = scanner.nextInt();
        System.out.println("Введено число " + a);
        System.out.println("Hello world!");

        // Узнать кол-во ядер ЦП
        System.out.println(Runtime.getRuntime().availableProcessors());

   //     System.out.println("\u0022");
   //     System.out.println('\u0027');
    }
}