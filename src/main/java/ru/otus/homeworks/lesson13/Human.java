package ru.otus.homeworks.lesson13;

import ru.otus.homeworks.lesson13.transport.Transport;

public class Human {
    private final String name;
    private Transport currentTransport;

    private static int energy;

    public Human(String name) {
        this.name = name;
        currentTransport = null;
        energy = 100;
    }

    public static int getEnergy() {
        return energy;
    }

    public static boolean reduceEnergy(int humanEnergySpent) {
        if (energy < humanEnergySpent) {
            System.out.println("У человека нет достаточного запаса сил");
            return false;
        }
        energy -= humanEnergySpent;
        System.out.println("Человек потратил " + humanEnergySpent + " сил");
        return true;
    }

    public void haveRest() {
        energy = 100;
        System.out.println("Человек отдохнул и полон сил");
    }

    public void setCurrentTransport(Transport transport) {
        this.currentTransport = transport;
        System.out.println("Человек пересел на " + transport.getTransportName());
    }

    public void leaveCurrentTransport() {
        this.currentTransport = null;
        System.out.println("Человек спешился");
    }

    public void move(int distance, Area area) {
        if (distance <= 0) {
            System.out.println("Неправильно указано расстояние, никуда не двигаемся");
            return;
        }
        if (currentTransport == null) {
            System.out.println("Человек идет пешком расстояние " + distance + "м по " + area.name() + " и не устает");
            return;
        }
        if (!currentTransport.tryMove(distance, area)) {
            System.out.println("Преодолеть дистанцию на " + currentTransport.getTransportName() + " не получится");
        }
    }

}
