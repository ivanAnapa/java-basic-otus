package ru.otus.homeworks.lesson22;

public class MyApp {
    /**
     * Необходимо выполнить две реализации задачи заполнения массива
     * Реализация №1:
     * - Реализуйте метод, который создает double массив длиной 100_000_000 элементов
     * - Метод должен должен циклом for пройти по каждому элементу и посчитать его значение по формуле:
     * array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
     * - Засеките время выполнения цикла и выведите его в консоль.
     * Реализация №2:
     * - Сделайте то же самое что и в реализации один, только чтобы массив заполняли 4 потока одновременно.
     * То есть первый поток заполняет первую четверть массива, второй - вторую и т.д.
     * И посмотрите насколько быстрее выполнится работа по сравнению с одним потоком.
     */

    public static void main(String[] args) {
        final int ARRAY_SIZE = 100_000_000;

        long impl1 = timeOfArrayFilling(ARRAY_SIZE, 1);
        long impl2 = timeOfArrayFilling(ARRAY_SIZE, 4);

        System.out.println("Время заполнения массива в 1 поток: " + impl1 + "мс");
        System.out.println("Время заполнения массива в 4 потока: " + impl2 + "мс");
        System.out.println("Разница во времени заполнения массива между 1 и 4 потоками: " + (impl1 - impl2) + "мс");
    }

    public static long timeOfArrayFilling(int arraySize, int numOfThreads) {
        double[] array = new double[arraySize];
        long beginTime = System.currentTimeMillis();

        Thread[] threads = new Thread[numOfThreads];
        for (int i = 0; i < numOfThreads; i++) {
            int index = i;
            threads[i] =
                    new Thread(() -> fillArray(
                            array,
                            (arraySize / numOfThreads) * index,
                            (arraySize / numOfThreads) * (index + 1))
                    );
        }

        for (int i = 0; i < numOfThreads; i++) {
            threads[i].start();
        }
        for (int i = 0; i < numOfThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return System.currentTimeMillis() - beginTime;
    }

    public static void fillArray(double[] array, int min, int max) {
        for (int i = min; i < max; i++) {
            array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
    }
}