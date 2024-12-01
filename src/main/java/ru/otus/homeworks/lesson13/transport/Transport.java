package ru.otus.homeworks.lesson13.transport;

import ru.otus.homeworks.lesson13.Area;

public abstract class Transport {
    protected String transportName;
    protected int maxEnergyLevel;
    protected int currentEnergy;
    protected boolean isAvailableArea;
    protected boolean isDriverAccepted = false;

    public String getTransportName() {
        return transportName;
    }


    public boolean tryMove(int distance, Area area) {
        if (!isAvailableArea) {
            System.out.println("Тип местности не подходит для данного транспорта");
            return false;
        }
        if (currentEnergy - distance < 0) {
            System.out.println("Расстояние сслишком большое, энергии не хватит");
            return false;
        }
        System.out.println("Расстояние " + distance + " успешно преодолено");
        return true;
    }

    public void reduceEnergy(int energySpent) {
        // Проверки на количство оставшейся энергии не добавлял, тк они выполняются в tryMove()
        currentEnergy -= energySpent;
        System.out.println("Запас энергии уменьшен на " + energySpent + "ед");
    }

    public void setDriver() {
        isDriverAccepted = true;
    }

    public void removeDriver() {
        isDriverAccepted = false;
    }

    public boolean isDriverAccepted() {
        return isDriverAccepted;
    }
}
