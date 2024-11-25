package ru.otus.homeworks.lesson16;

/**
 * 5. Создайте класс Сотрудник с полями: имя, возраст;
 */
public class Employee {
    private final String name;
    private final int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void printEmployeeData() {
        System.out.print("Работник по имени " + name + ", возраст " + age + " лет");
    }
}
