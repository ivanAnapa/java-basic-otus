package ru.otus.homeworks.lesson31;

/**
 * Описание/Пошаговая инструкция выполнения домашнего задания:
 * Создайте пул потоков
 * Задайте пулу три задачи: первая должна 5 раз напечатать букву A, вторая - B, третья - C
 * Синхронизируйте потоки в пуле таким образом, чтобы в любой ситуации в консоль печаталась последовательность ABCABCABCABCABC
 * После печати всех символов программа должна завершиться
 */

public class HW21 {
    public static void main(String[] args) throws InterruptedException {

        Printer printer = new Printer(3);

        String[] symbolsA = {"A", "A", "A", "A", "A"};
        String[] symbolsB = {"B", "B", "B", "B", "B"};
        String[] symbolsC = {"C", "C", "C", "C", "C"};

        Thread thread1 = new Thread(() -> {
            for (String s : symbolsA) {
                try {
                    printer.print(s, 1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (String s : symbolsB) {
                try {
                    printer.print(s, 2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread thread3 = new Thread(() -> {
            for (String s : symbolsC) {
                try {
                    printer.print(s, 3);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

    }
}
