package ru.otus.homeworks.lesson12;

public class Cat {
    private final String name;
    private final int appetite;
    private boolean isHungry;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        isHungry = true;
    }

    public void eat(Plate plate) {
        if (!isHungry) {
            System.out.println("Кот " + name + " не будет есть, он сыт");
            return;
        }
        if (plate.reduceFood(appetite)) {
            System.out.println("Кот " + name + " поел");
            isHungry = false;
        } else {
            System.out.println("Кот " + name + " не будет есть, еды мало");
        }
    }

    public void info() {
        if (!isHungry) {
            System.out.println("Кот " + name + " сыт");
            return;
        }
        System.out.println("Кот " + name + " голоден");
    }
}
