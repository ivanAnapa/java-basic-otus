package ru.otus.homeworks.lesson13;

import ru.otus.homeworks.lesson13.transport.Transport;

public class Human {
    private final String name;
    private Transport currentTransport;
    private int energy;

    public Human(String name) {
        this.name = name;
        currentTransport = null;
        energy = 100;
    }

    public int getEnergy() {
        return energy;
    }

    public void reduceEnergy(int energySpent) {
        if (energy < energySpent) {
            System.out.println("У человека с именем " + name + " нет достаточного запаса сил");
            return;
        }
        energy -= energySpent;
        System.out.println(name + " потратил " + energySpent + " сил");
    }

    public void haveRest() {
        energy = 100;
        System.out.println(name + " отдохнул и полон сил");
    }

    public void setCurrentTransport(Transport transport) {
        this.currentTransport = transport;
        System.out.println(name + " пересел на " + transport.getTransportName());
    }

    public void leaveCurrentTransport() {
        this.currentTransport = null;
        System.out.println(name + " спешился");
    }

    public void move(int distance, Area area) {
        if (distance <= 0) {
            System.out.println("Неправильно указано расстояние, никуда не двигаемся");
            return;
        }
        if (currentTransport == null) {
            System.out.println(name + " идет пешком расстояние " + distance + "м по '" + area.getAreaRuName() + "' и не устает");
            return;
        }
        if (!currentTransport.tryMove(distance, area)) {
            System.out.println("Преодолеть дистанцию на " + currentTransport.getTransportName() + " не получится");
        }
    }

}
