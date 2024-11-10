package ru.otus.homeworks.lesson11.animals;

public class Dog extends Animal {
    public Dog(String name, int runSpeed, int swimSpeed, int endurance) {
        super(name, runSpeed, swimSpeed, endurance);
    }

    public float swim(int distance) {
        if (endurance == 0) {
            System.out.println("Собака устала и плыть не может");
            return -1;
        }
        System.out.println("Заплыв начат. Предстоящая дистанция: " + distance + "м");
        if ((endurance * 2) < distance) {
            System.out.println("Расстояние слишком большое. Плавание закончено: выносливости хватило на "
                    + (endurance / 2) + "м");
            System.out.println("До финиша оставалось " + (distance - (endurance / 2))
                    + "м, но у животного появилось состояние усталости");
            endurance = 0;
            return -1;
        }
        int time = distance / swimSpeed;
        endurance -= distance * 2;
        System.out.println("Заплыв на " + distance + "м завершен. Затрачено времени: "
                + time + "с со скоростью " + swimSpeed + "м/с");
        return time;
    }
}
