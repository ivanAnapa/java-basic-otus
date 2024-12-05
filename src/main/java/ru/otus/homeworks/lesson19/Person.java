package ru.otus.homeworks.lesson19;

public class Person {
    private String name;
    private Position position;
    private Long id;

    Person(String name, Position position, long id) {
        this.name = name;
        this.position = position;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "name: " + name + ", position: " + position + ", id: " + id;
    }
}