package ru.otus.homeworks.lesson11.animals;

public class Cat extends Animal {
    public Cat(String name, int runSpeed, int endurance) {
        super(name, runSpeed, endurance);
    }

    @Override
    public float swim(int distance) {
        System.out.println("Кот не умеет плавать: не царское это дело, плывите сами...");
        return 0;
    }
}
