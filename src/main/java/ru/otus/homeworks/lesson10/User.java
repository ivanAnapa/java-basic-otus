package ru.otus.homeworks.lesson10;

/** часть 1.1
 * Описание/Пошаговая инструкция выполнения домашнего задания:
 * Создайте класс Пользователь (User) с полями: фамилия, имя, отчество, год рождения, email;
 * Реализуйте у класса конструктор, позволяющий заполнять эти поля при создании объекта;
 * В классе Пользователь реализуйте метод, выводящий в консоль информацию о пользователе в виде:
 * ФИО: фамилия имя отчество
 * Год рождения: год рождения
 * e-mail: email
 */

public class User {
    private String lastName;
    private String firstName;
    private String patronymicName;
    private int birthYear;
    private String email;

    public int getBirthYear() {
        return birthYear;
    }

    public User(String lastName, String firstName, String patronymicName, int birthYear, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymicName = patronymicName;
        this.birthYear = birthYear;
        this.email = email;
    }

    public void printUserInfo() {
        System.out.println("ФИО: " + lastName + " " + firstName + " " + patronymicName);
        System.out.println("Год рождения: " + birthYear);
        System.out.println("e-mail: " + email);
        System.out.println();
    }

}
