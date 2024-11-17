package ru.otus.homeworks.lesson13.transport;

import ru.otus.homeworks.lesson13.Area;

public class Horse extends Transport {
    public Horse(String horseName) {
        transportName = horseName;
        // Запас выносливости = 70ед и при создании лошадь полна сил
        maxEnergyLevel = 70;
        currentEnergy = maxEnergyLevel;
    }

    public boolean tryMove(int distance, Area area) {
        if (!area.getIsAvailableForHorse()) {
            System.out.print("Тип местности не подходит для " + transportName + ". ");
            return false;
        }
        if (currentEnergy - distance < 0) {
            System.out.print("Расстояние сслишком большое, энергии не хватит. ");
            return false;
        }
        System.out.print("Расстояние " + distance + " успешно преодолено по " + area.name() + " на лошади. ");
        reduceEnergy(distance);
        return true;
    }
}
