package ru.otus.homeworks.lesson18;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<String, ArrayList<String>> phoneBook;

    PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void add(String fullName, String phoneNumber) {
        if (containsPhoneNumber(phoneNumber)) {
            System.out.println("Такой номер уже присутствует в книге");
        } else {
            phoneBook.putIfAbsent(fullName, new ArrayList<>());
            phoneBook.get(fullName).add(phoneNumber);
            System.out.println("В книгу добавлена запись: " + fullName + " " + phoneNumber);
        }
    }

    public Map<String, List<String>> find(String nameForSearching) {
        Map<String, List<String>> result = new HashMap<>();
        for (Map.Entry<String, ArrayList<String>> entry : phoneBook.entrySet()) {
            String name = entry.getKey();
            List<String> numbers = entry.getValue();
            if (name.equals(nameForSearching)) {
                result.put(name, numbers);
            }
        }
        return result;
    }

    public boolean containsPhoneNumber(String expectedNumber) {
        for (Map.Entry<String, ArrayList<String>> entry : phoneBook.entrySet()) {
            List<String> phoneNumbers = entry.getValue();
            for (String phoneNumber : phoneNumbers) {
                if (phoneNumber.equals(expectedNumber))
                    return true;
            }
        }
        return false;
    }

    public void printPhoneBook() {
        if (phoneBook.isEmpty()) {
            System.out.println("Записей в книге нет");
            return;
        }
        System.out.println("\nТекущие записи в книге:");
        for (Map.Entry<String, ArrayList<String>> entry : phoneBook.entrySet()) {
            System.out.println("Имя: " + entry.getKey() + ", номер(-а): " + entry.getValue());
        }
    }
}
