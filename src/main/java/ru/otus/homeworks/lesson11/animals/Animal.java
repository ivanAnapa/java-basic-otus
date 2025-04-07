package ru.otus.homeworks.lesson11.animals;

public abstract class Animal {
    // У каждого животного есть имя, скорость бега и плавания (м/с), и выносливость (измеряется в условных единицах)
    protected String name;
    protected int runSpeed;
    protected int swimSpeed;
    protected int endurance;

    public Animal(String name, int runSpeed, int endurance) {
        this.name = name;
        this.runSpeed = runSpeed;
        this.endurance = endurance;
    }

    public Animal(String name, int runSpeed, int swimSpeed, int endurance) {
        this.name = name;
        this.runSpeed = runSpeed;
        this.swimSpeed = swimSpeed;
        this.endurance = endurance;
    }

    /*
    Реализуйте методы run(int distance) и swim(int distance), которые должны возвращать время, затраченное на
    указанное действие, и “понижать выносливость” животного.
    Если выносливости не хватает, то возвращаем время -1 и указываем что у животного появилось состояние усталости.
    При выполнении действий пишем сообщения в консоль.
     */
    public float run(int distance) {
        if (endurance == 0) {
            System.out.println("Животное " + this.getClass().getSimpleName() + " устало и бежать не может");
            return -1;
        }
        System.out.println("Бег начат. Предстоящая дистанция: " + distance + "м");
        if (endurance < distance) {
            System.out.println("Расстояние слишком большое. Бег закончен: выносливости хватило на " + endurance + "м");
            System.out.println("До финиша оставалось "
                    + (distance - endurance) + "м, но у животного появилось состояние усталости");
            endurance = 0;
            return -1;
        }
        int time = distance / runSpeed;
        endurance -= distance;
        System.out.println("Бег на " + distance + "м завершен. Затрачено времени: "
                + time + "с со скоростью " + runSpeed + "м/с");
        return time;
    }

    public abstract float swim(int distance);

    // Добавляем метод info(), который выводит в консоль состояние животного
    public void info() {
        System.out.println("Животное: " + this.getClass().getSimpleName() + ", Имя: "
                + name + ", Текущая выносливость: " + endurance);
    }
}
