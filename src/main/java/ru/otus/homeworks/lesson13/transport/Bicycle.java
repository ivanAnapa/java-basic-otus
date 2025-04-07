package ru.otus.homeworks.lesson13.transport;

import ru.otus.homeworks.lesson13.Area;
import ru.otus.homeworks.lesson13.Human;

public class Bicycle extends Transport {
    private final Human humanLocal;

    public Bicycle(String bicycleModel, Human human) {
        transportName = bicycleModel;
        humanLocal = human;
    }

    public boolean tryMove(int distance, Area area) {
        if (area.equals(Area.Swamp)) {
            System.out.print("Тип местности '" + area.getAreaRuName() + "' не подходит для велосипеда " + transportName + ". ");
            return false;
        }
        // Считаем, что на 1м дистанции велосипед тратит 1ед энергии человека
        if ((humanLocal.getEnergy() - distance) < 0) {
            System.out.print("Расстояние слишком большое, сил человека не хватит. ");
            return false;
        }
        System.out.print("Расстояние " + distance + " успешно преодолено по '" + area.getAreaRuName() + "' на велосипеде. ");
        humanLocal.reduceEnergy(distance);
        return true;
    }
}
