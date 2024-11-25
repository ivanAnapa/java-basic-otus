package ru.otus.homeworks.lesson16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1. Реализуйте метод, принимающий в качестве аргументов числа min и max, и возвращающий ArrayList с набором
 * последовательных значений в указанном диапазоне (min и max включительно, шаг - 1);
 * 2. Реализуйте метод, принимающий в качестве аргумента список целых чисел, суммирующий все элементы,
 * значение которых больше 5, и возвращающий сумму;
 * 3. Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на список, метод должен переписать каждую
 * заполненную ячейку списка указанным числом;
 * 4. Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на список, увеличивающий каждый элемент
 * списка на указанное число;
 * 5. Создайте класс Сотрудник с полями: имя, возраст;
 * 6. Реализуйте метод, принимающий в качестве аргумента список сотрудников, и возвращающий список их имен;
 * 7. Реализуйте метод, принимающий в качестве аргумента список сотрудников и минимальный возраст, и возвращающий список
 * сотрудников, возраст которых больше либо равен указанному аргументу;
 * 8. Реализуйте метод, принимающий в качестве аргумента список сотрудников и минимальный средний возраст, и проверяющий
 * что средний возраст сотрудников превышает указанный аргумент;
 * 9. Реализуйте метод, принимающий в качестве аргумента список сотрудников, и возвращающий ссылку на самого молодого сотрудника.
 */
public class MyApp {
    public static void main(String[] args) {
        // Задание 1
        List<Integer> exercise1 = createListInRange(3, 7);
        System.out.println("Результат задания 1: " + exercise1);

        // Задание 2 (решил использовать тут массив из задания 1 - не пропадать же добру:)
        int exercise2 = calcSum(exercise1);
        System.out.println("Результат задания 2: " + exercise2);

        // Задание 3
        List<Integer> exercise3 = createListInRange(1, 10);
        rewriteArray(99, exercise3);
        System.out.println("Результат задания 3: " + exercise3);

        // Задание 4
        List<Integer> exercise4 = createListInRange(1, 10);
        increaseArray(5, exercise4);
        System.out.println("Результат задания 4: " + exercise4);

        // Задание 5
        Employee emp = new Employee("Василий", 37);
        emp.printEmployeeData();
        System.out.println();

        // Задание 6
        Employee[] employee = {
                new Employee("Евлампий", 37),
                new Employee("Митрофан", 31),
                new Employee("Иммануил", 17),
                new Employee("Бронислав", 23),
                new Employee("Аристарх", 45),
        };
        List<String> namesForExercise6 = createNamesList(employee);
        System.out.println("Результат задания 6: " + namesForExercise6);

        // Задание 7
        List<String> namesForExercise7 = selectEmployeesWithAgeEqualsOrMoreThanMinAge(employee, 20);
        System.out.println("Результат задания 7: " + namesForExercise7);

        // Задание 8
        System.out.println("Результат задания 8.1: " + checkAvgAge(employee, 25));
        System.out.println("Результат задания 8.2: " + checkAvgAge(employee, 35));

        // Задание 9
        int indexOfEmployeeWithMinAge = findEmployeeWithMinAge(employee);
        System.out.println("Результат задания 9: ");
        employee[indexOfEmployeeWithMinAge].printEmployeeData();
        System.out.println(" - самый молодой");

    }

    /*
    1. Реализуйте метод, принимающий в качестве аргументов числа min и max, и возвращающий ArrayList с набором
    последовательных значений в указанном диапазоне (min и max включительно, шаг - 1);
     */
    public static ArrayList<Integer> createListInRange(int min, int max) {
        ArrayList<Integer> intList = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            intList.add(i);
        }
        return intList;
    }

    /*
    2. Реализуйте метод, принимающий в качестве аргумента список целых чисел, суммирующий все элементы,
    значение которых больше 5, и возвращающий сумму;
     */
    public static int calcSum(List<Integer> list) {
        int result = 0;
        for (Integer integer : list) {
            if (integer > 5) {
                result += integer;
            }
        }
        return result;
    }

    /*
    3. Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на список, метод должен переписать
    каждую заполненную ячейку списка указанным числом;
     */
    public static void rewriteArray(int newValue, List<Integer> list) {
        // Сначала сделал через for(), а Idea предложила такой вариант. Он компактнее, решил оставить
        Collections.fill(list, newValue);
    }

    /*
    4. Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на список, увеличивающий каждый элемент
    списка на указанное число;
     */
    public static void increaseArray(int valueToIncrease, List<Integer> list) {
        // Тоже Idea предложила такое решение вместо моего. Работает также, но симпатичнее
        list.replaceAll(integer -> (integer + valueToIncrease));
    }

    /*
    6. Реализуйте метод, принимающий в качестве аргумента список сотрудников, и возвращающий список их имен;
     */
    public static List<String> createNamesList(Employee[] employees) {
        List<String> listOfNames = new ArrayList<>();
        for (Employee employee : employees) {
            listOfNames.add(employee.getName());
        }
        return listOfNames;
    }

    /*
    7. Реализуйте метод, принимающий в качестве аргумента список сотрудников и минимальный возраст,
    и возвращающий список сотрудников, возраст которых больше либо равен указанному аргументу;
     */
    public static List<String> selectEmployeesWithAgeEqualsOrMoreThanMinAge(Employee[] employees, int minAge) {
        List<String> listOfNames = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getAge() >= minAge) {
                listOfNames.add(employee.getName());
            }
        }
        return listOfNames;
    }

    /*
    8. Реализуйте метод, принимающий в качестве аргумента список сотрудников и минимальный средний возраст,
    и проверяющий что средний возраст сотрудников превышает указанный аргумент;
     */
    public static Boolean checkAvgAge(Employee[] employees, int minAvgAge) {
        int sumOfAges = 0;
        for (Employee employee : employees) {
            sumOfAges += employee.getAge();
        }
        return (sumOfAges / employees.length) > minAvgAge;
    }

    /*
    9. Реализуйте метод, принимающий в качестве аргумента список сотрудников, и возвращающий ссылку на самого
    молодого сотрудника.
     */
    public static int findEmployeeWithMinAge(Employee[] employees) {
        int minAge = employees[0].getAge();
        int indexOfYoungest = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() < minAge) {
                minAge = employees[i].getAge();
                indexOfYoungest = i;
            }
        }
        return indexOfYoungest;
    }
}
