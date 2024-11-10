package ru.otus.homeworks.lesson11.animals;

public class Horse extends Animal {
    public Horse(String name, int runSpeed, int swimSpeed, int endurance) {
        super(name, runSpeed, swimSpeed, endurance);
    }

    public float swim(int distance) {
        if (endurance == 0) {
            System.out.println("Лошадь устала и плыть не может");
            return -1;
        }
        System.out.println("Заплыв начат. Предстоящая дистанция: " + distance + "м");
        if ((endurance * 4) < distance) {
            System.out.println("Расстояние слишком большое. Плавание закончено: выносливости хватило на "
                    + (endurance * 4) + "м");
            System.out.println("До финиша оставалось " + (distance - (endurance * 4))
                    + "м, но у животного появилось состояние усталости");
            endurance = 0;
            return -1;
        }
        int time = distance / swimSpeed;
        endurance -= distance * 4;
        System.out.println("Заплыв на " + distance + "м завершен. Затрачено времени: " + time
                + "с со скоростью " + swimSpeed + "м/с");
        return time;
    }
}
