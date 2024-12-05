package ru.otus.homeworks.lesson19;

import java.util.HashMap;
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
    private Map<Long, Person> persons;

    public PersonDataBase() {
        persons = new HashMap<>();
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
        return person.getPosition().equals(Position.MANAGER)
                || person.getPosition().equals(Position.DIRECTOR)
                || person.getPosition().equals(Position.BRANCH_DIRECTOR)
                || person.getPosition().equals(Position.SENIOR_MANAGER);
    }

    public Boolean isEmployee(Long id) {
        return !isManager(findById(id));
    }
}
