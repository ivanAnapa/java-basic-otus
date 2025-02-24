package ru.otus.homeworks.homeworks.lesson28;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Описание/Пошаговая инструкция выполнения домашнего задания:
 * Создайте классы Fruit, Apple extends Fruit, Orange extends Fruit;
 * Создайте класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта:
 * - Box только для яблок,
 * - Box только для апельсин,
 * - Box и для тех, и для других фруктов.
 * Для хранения фруктов внутри коробки используйте ArrayList;
 * Реализуйте метод добавления фрукта в коробку;
 * Реализуйте метод weight, который высчитывает вес коробки (например, из веса одного фрукта и их количества, или
 * может через суммирование, как посчитаете нужным). Вес фрукта задаете самостоятельно, единицы измерения не важны;
 * Реализуйте метод compare, позволяющий сравнить текущую коробку с переданной в качестве аргумента.
 * true – если их массы равны. Можно сравнивать коробки с разными типами фруктов;
 * Реализуйте метод, позволяющий пересыпать фрукты из текущей коробки в другую. Помним про сортировку фруктов в коробках;
 */

public class Hw19App {
    private static final Logger logger = LogManager.getLogger(Hw19App.class);

    public static void main(String[] args) {

        Box<Apple> boxForApples1 = new Box<>();
        Box<Apple> boxForApples2 = new Box<>();
        Box<Orange> boxForOranges = new Box<>();
        Box<Fruit> multiFruitBox = new Box<>();

        boxForApples1.add(new Apple(10));
        boxForApples1.getWeight();
        boxForApples2.add(new Apple(30));
        boxForApples2.getWeight();

        boxForOranges.add(new Orange(15));
        boxForOranges.getWeight();

        logger.info("***************** Сравнение веса коробок с яблоками и апельсинами *****************");
        logger.info(boxForApples1.compare(boxForOranges) ? "Коробки весят одинаково" : "Вес коробок отличается");

        logger.info("***************** Пересыпаем яблоки из коробки 1 в коробку 2 *****************");
        boxForApples2.pourFruitsIntoBox(boxForApples1);
        boxForApples1.getWeight();
        boxForApples2.getWeight();

        logger.info("******** Пересыпаем яблоки из коробки 2 и апельсины в коробку для смешанных фруктов ********");
        multiFruitBox.pourFruitsIntoBox(boxForApples2);
        multiFruitBox.pourFruitsIntoBox(boxForOranges);
        multiFruitBox.getWeight();
        boxForApples2.getWeight();
        boxForOranges.getWeight();

        // Корявые кейсы
        /*
        Пересыпать микс фруктов в коробку для яблок нельзя:
        Required type: Box<? extends Apple>
        Provided: Box<Fruit>
         */
        // boxForApples1.pourFruitsIntoBox(multiFruitBox);

        /*
         Пересыпать апельсины в коробку для яблок нельзя:
         Required type: Box<? extends Apple>
         Provided: Box<Orange>
         */
        // boxForApples1.pourFruitsIntoBox(boxForOranges);

        // ConcurrentModificationException при попытке пересыпать коробку в саму себя
        // multiFruitBox.pourFruitsIntoBox(multiFruitBox);
    }
}
