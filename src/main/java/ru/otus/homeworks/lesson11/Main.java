package ru.otus.homeworks.lesson11;

import ru.otus.homeworks.lesson11.animals.Cat;
import ru.otus.homeworks.lesson11.animals.Dog;
import ru.otus.homeworks.lesson11.animals.Horse;

/**
 * Создайте классы Cat, Dog и Horse с наследованием от класса Animal
 * У каждого животного есть имя, скорость бега и плавания (м/с), и выносливость (измеряется в условных единицах)
 * Затраты выносливости:
 * Все животные на 1 метр бега тратят 1 ед выносливости,
 * Собаки на 1 метр плавания - 2 ед.
 * Лошади на 1 метр плавания тратят 4 единицы
 * Кот плавать не умеет.
 * Реализуйте методы run(int distance) и swim(int distance), которые должны возвращать время, затраченное на указанное действие, и “понижать выносливость” животного. Если выносливости не хватает, то возвращаем время -1 и указываем что у животного появилось состояние усталости. При выполнении действий пишем сообщения в консоль.
 * Добавляем метод info(), который выводит в консоль состояние животного.
 */
public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Vasiliy", 5, 100);
        System.out.println("Кот");
        cat.info();
        cat.swim(123);
        cat.info();
        cat.run(25);
        cat.info();
        cat.run(222);
        cat.info();
        cat.run(1);

        System.out.println("\nСобака");
        Dog dog = new Dog("Barbos", 10, 3, 200);
        dog.info();
        dog.swim(30);
        dog.info();
        dog.run(100);
        dog.info();
        dog.run(40);
        dog.info();
        dog.run(1);
        dog.swim(1);

        System.out.println("\nЛошадь");
        Horse horse = new Horse("Shustrik", 30, 5, 500);
        horse.info();
        horse.run(90);
        horse.info();
        horse.swim(100);
        horse.info();
        horse.swim(100);
        horse.run(60);
        horse.swim(10);
    }
}
