package ru.otus.homeworks.lesson29;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Описание/Пошаговая инструкция выполнения домашнего задания:
 * Реализуйте метод, который подсчитывает сколько раз в текстовом файле (с кодировкой UTF-8) встречается указанная
 * последовательность символов с учетом регистра;
 * При запуске приложения пользователь вводит имя файла и искомую последовательность символов,
 * программа должна выполнить расчет и напечатать результат в консоль.
 */
public class HW20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите название файла: ");
        String fileName = scanner.nextLine();

        System.out.print("Введите символы, которые требуется посчитать: ");
        String symbolsForSearching = scanner.nextLine();

        int result = calcNumOfSymbolsInFile(fileName, symbolsForSearching);
        System.out.printf("Количество символов '%s' в файле '%s' равно %s", symbolsForSearching, fileName, result);
    }

    public static int calcNumOfSymbolsInFile(String fileName, String symbolsForSearching) {
        try (FileInputStream fis = new FileInputStream(fileName)) {
            byte[] buffer = fis.readAllBytes();
            String text = new String(buffer, StandardCharsets.UTF_8);
            int count = 0;
            int symbolsIndex = 0;
            while ((symbolsIndex = text.indexOf(symbolsForSearching, symbolsIndex)) >= 0) {
                symbolsIndex += symbolsForSearching.length();
                count++;
            }
            return count;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
