package ru.otus.homeworks.lesson13;

import ru.otus.homeworks.lesson13.transport.*;

/**
 * Создайте класс Человек с полями name (имя) и currentTransport (текущий транспорт)
 * Реализуйте в вашем приложении классы Машина, Лошадь, Велосипед, Вездеход
 * Каждый из классов должен предоставлять возможность перемещаться на определенное расстояние с указанием типа местности
 * В приложении должны быть типы местности: густой лес, равнина, болото
 * Человек должен иметь возможность сесть на любой из этих видов транспорта, встать с него, или переместиться
 * на некоторое расстояние (при условии что он находится на каком-либо транспорте)
 * При попытке выполнить перемещение у человека, не использующего транспорт, считаем что он просто
 * идет указанное расстояние пешком
 * При перемещении Машина и Вездеход тратят бензин, который у них ограничен. Лошадь тратит силы.
 * Велосипед может использоваться без ограничений (можете для усложнения велосипедом тратить силы “водителя”).
 * При выполнении действия результат должен быть отпечатан в консоль
 * У каждого вида транспорта есть местности по которым он не может перемещаться:
 * машина - густой лес и болото, лошадь и велосипед - болото, вездеход - нет ограничений
 * При попытке переместиться должен быть возвращен результат true/false - удалось ли выполнить действие
 */
public class Main {

    public static void main(String[] args) {
        Human vasiliy = new Human("Василий");
        Transport[] transports = {
                new Car("Audi"),
                new Bicycle("Desna", vasiliy),
                new Horse("Veterok"),
                new AllTerrainVehicle("Buggy")
        };

        vasiliy.move(0, Area.Plain);
        vasiliy.move(10, Area.Forest);

        for (Transport transport : transports) {
            System.out.println("\n***************** " + transport.getTransportName() + " *******************");
            vasiliy.setCurrentTransport(transport);
            vasiliy.move(20, Area.Forest);
            vasiliy.move(30, Area.Swamp);
            vasiliy.move(40, Area.Plain);
            vasiliy.move(400, Area.Plain);

            vasiliy.leaveCurrentTransport();
            vasiliy.move(50, Area.Swamp);
        }

        System.out.println("\n******** Проверка: уставший человек сможет проехать на велосипеде после отдыха ********");
        vasiliy.setCurrentTransport(transports[1]);
        vasiliy.move(80, Area.Plain);
        vasiliy.haveRest();
        vasiliy.move(80, Area.Plain);

        System.out.println("\n******** Проверка: водитель не может ехать одновременно на 2 транспортах ********");
        vasiliy.setCurrentTransport(transports[0]);


        System.out.println("\n******** Проверка: у транспорта не может быть более 1 водителя ********");
        Human petr = new Human("Петр");
        petr.setCurrentTransport(transports[1]);
        vasiliy.setCurrentTransport(transports[1]);

    }
}
