package ru.otus.homeworks.lesson13.transport;

import ru.otus.homeworks.lesson13.Area;
import ru.otus.homeworks.lesson13.Human;

public class Bicycle extends Transport {

    public Bicycle() {
        currentEnergy = Human.getEnergy();
    }

    public Bicycle(String bicycleModel) {
        transportName = bicycleModel;
    }

    public boolean tryMove(int distance, Area area) {
        if (!area.getIsAvailableForBicycle()) {
            System.out.print("Тип местности " + area.name() + " не подходит для велосипеда " + transportName + ". ");
            return false;
        }
        // Считаем, что на 1м дистанции велосипед тратит 1ед энергии человека
        if ((Human.getEnergy() - distance) < 0) {
            System.out.print("Расстояние слишком большое, сил человека не хватит. ");
            return false;
        }
        System.out.print("Расстояние " + distance + " успешно преодолено по " + area.name() + " на велосипеде. ");
        Human.reduceEnergy(distance);
        return true;
    }
}
