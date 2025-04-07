package ru.otus.homeworks.lesson19;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Написать класс PersonDataBase, содержащий список Person, и имеющий следующие методы, со следующей
 * асимптотической сложностью (методы и конструктор класса Person реализовать самостоятельно)
 * <p>
 * Person findById(Long id) - найти Person по id - O(1)
 * void add(Person person) - добавить Person - O(1)
 * isManager(Person person) - O(1) - true если Position : MANAGER, DIRECTOR, BRANCH_DIRECTOR или SENIOR_MANAGER
 * isEmployee(Long id) - O(1) - true если Employee имеет любой другой Position
 */
public class PersonDataBase {
    private final Map<Long, Person> persons;
    private final HashSet<Position> managers = new HashSet<>();

    public PersonDataBase() {
        persons = new HashMap<>();

        managers.add(Position.MANAGER);
        managers.add(Position.DIRECTOR);
        managers.add(Position.BRANCH_DIRECTOR);
        managers.add(Position.SENIOR_MANAGER);
    }

    public Person findById(long id) {
        if (!persons.containsKey(id)) {
            System.out.println("\nУказанного id = " + id + " нет в базе");
            return null;
        }
        return persons.get(id);
    }

    void add(Person person) {
        persons.putIfAbsent(person.getId(), person);
    }

    public Boolean isManager(Person person) {
        return managers.contains(person.getPosition());
    }

    public Boolean isEmployee(Long id) {
        return !isManager(findById(id));
    }
}
