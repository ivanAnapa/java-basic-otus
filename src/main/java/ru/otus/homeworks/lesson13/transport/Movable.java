package ru.otus.homeworks.lesson13.transport;

import ru.otus.homeworks.lesson13.Area;

public interface Movable {
    public boolean move(int distance, Area area);
    public void reduceEnergy(int distance, Area area);
}
