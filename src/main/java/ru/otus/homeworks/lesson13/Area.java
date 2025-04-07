package ru.otus.homeworks.lesson13;

public enum Area {
    Forest("Лес"),
    Plain("Поле"),
    Swamp("Болото");

    private final String areaNameRu;

    public String getAreaRuName() {
        return areaNameRu;
    }

    Area(String areaNameRu) {
        this.areaNameRu = areaNameRu;
    }
}
