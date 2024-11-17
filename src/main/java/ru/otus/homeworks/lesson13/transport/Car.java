package ru.otus.homeworks.lesson13.transport;

import ru.otus.homeworks.lesson13.Area;

public class Car extends Transport {

    public Car(String carModel) {
        transportName = carModel;
        // Объем бака = 100л и при создании машина полностью заправлена
        maxEnergyLevel = 100;
        currentEnergy = maxEnergyLevel;
    }

    public boolean tryMove(int distance, Area area) {
        if (!area.getIsAvailableForCar()) {
            System.out.print("Тип местности " + area.name() + " не подходит для машины. ");
            return false;
        }
        // Считаем, что на 1м дистанции машина тратит 2л топлива
        if ((currentEnergy - (distance * 2)) < 0) {
            System.out.print("Расстояние слишком большое, бензина не хватит. ");
            return false;
        }
        System.out.print("Расстояние " + distance + " успешно преодолено на " + getTransportName() + " по типу местности " + area.name() + ". ");
        reduceEnergy(distance * 2);
        return true;
    }
}
