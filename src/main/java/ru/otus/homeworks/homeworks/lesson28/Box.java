package ru.otus.homeworks.homeworks.lesson28;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Box<F extends Fruit> {
    private static final Logger logger = LogManager.getLogger(Box.class);
    private final List<F> fruits;
    private int weight;

    public Box() {
        this.fruits = new ArrayList<F>();
    }

    public int getWeight() {
        logger.info("Вес коробки составляет {}кг", weight);
        return weight;
    }

    public void add(F fruit) {
        logger.info("Добавление {}кг фруктов {} в коробку", fruit.weight, fruit.getClass().getSimpleName());
        weight += fruit.weight;
        fruits.add(fruit);
    }

    public boolean compare(Box<?> box) {
        return this.weight == box.weight;
    }

    public void pourFruitsIntoBox(Box<? extends F> box) {
        for (Fruit f : box.fruits) {
            this.add((F) f);
        }
        box.weight = 0;
        box.fruits.clear();
    }
}
