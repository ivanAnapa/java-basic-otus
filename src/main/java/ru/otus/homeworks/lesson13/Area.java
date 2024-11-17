package ru.otus.homeworks.lesson13;

public enum Area {
    Forest(true, true, false, true),
    Plain(true, true, true, true),
    Swamp(false, true, false, false);

    private boolean isAvailableForBicycle;
    private boolean isAvailableForAllTerrainVehicle;
    private boolean isAvailableForCar;
    private boolean isAvailableForHorse;

    public boolean getIsAvailableForBicycle() {
        return isAvailableForBicycle;
    }

    public boolean getIsAvailableForAllTerrainVehicle() {
        return isAvailableForAllTerrainVehicle;
    }

    public boolean getIsAvailableForCar() {
        return isAvailableForCar;
    }

    public boolean getIsAvailableForHorse() {
        return isAvailableForHorse;
    }

    Area(
            boolean isAvailableForBicycle,
            boolean isAvailableForAllTerrainVehicle,
            boolean isAvailableForCar,
            boolean isAvailableForHorse) {
        this.isAvailableForBicycle = isAvailableForBicycle;
        this.isAvailableForAllTerrainVehicle = isAvailableForAllTerrainVehicle;
        this.isAvailableForCar = isAvailableForCar;
        this.isAvailableForHorse = isAvailableForHorse;
    }

}
