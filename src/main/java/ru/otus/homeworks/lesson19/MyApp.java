package ru.otus.homeworks.lesson19;

public class MyApp {
    public static void main(String[] args) {
        PersonDataBase personDataBase = new PersonDataBase();
        Person[] persons = {
                new Person("Anton", Position.JUNIOR_DEVELOPER, 1L),
                new Person("Alex", Position.BRANCH_DIRECTOR, 2L),
                new Person("Andrey", Position.DEVELOPER, 3L),
                new Person("Gleb", Position.DRIVER, 4L),
                new Person("Mary", Position.ENGINEER, 5L),
                new Person("Ivan", Position.QA, 6L),
                new Person("Boris", Position.JANITOR, 7L),
                new Person("Nataly", Position.PLUMBER, 8L),
                new Person("Elsa", Position.JUNIOR_DEVELOPER, 9L),
                new Person("Mike", Position.DRIVER, 10L),
                new Person("Max", Position.MANAGER, 11L),
                new Person("Sam", Position.DIRECTOR, 12L),
                new Person("Nik", Position.SENIOR_MANAGER, 13L),
        };

        for (Person person : persons) {
            personDataBase.add(person);
            System.out.println("\nЯвляется ли менеджером " + person.getName() + "? " + personDataBase.isManager(person));
            System.out.println("Является ли обычным работником " + person.getName() + "? " + personDataBase.isEmployee(person.getId()));
            System.out.println(person);
        }

        personDataBase.findById(999L);
    }
}
