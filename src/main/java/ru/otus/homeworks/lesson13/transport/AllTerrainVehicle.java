package ru.otus.homeworks.lesson13.transport;

import ru.otus.homeworks.lesson13.Area;

public class AllTerrainVehicle extends Transport {

    public AllTerrainVehicle(String vehicleModel) {
        transportName = vehicleModel;
        // Объем бака = 550л и при создании вездеход полностью заправлен
        maxEnergyLevel = 550;
        currentEnergy = maxEnergyLevel;
    }

    public boolean tryMove(int distance, Area area) {
        /*
        Не уверен, что проверка на местность нужна: для вездехода нет ограничений, но они могут появиться, если добавить
        в enum "воду". С другой стороны, если добавим "пустыня", то это не будет ограничением. Решил закомментировать проверку
        if (!area.equals(Area.Swamp) || !area.equals(Area.Forest) || !area.equals(Area.Plain)) {
            System.out.print("Тип местности не подходит для вездехода " + transportName + ". ");
            return false;
        }*/
        // Считаем, что на 1м дистанции вездеход тратит 5л топлива
        if ((currentEnergy - (distance * 5)) < 0) {
            System.out.print("Расстояние сслишком большое, бензина не хватит. ");
            return false;
        }
        System.out.print("Расстояние " + distance + " успешно преодолено по '" + area.getAreaRuName() + "' на внедорожнике. ");
        reduceEnergy(distance * 5);
        return true;
    }
}
