package ru.otus.homeworks.lesson10;

import java.time.Year;

public class Main {
    public static void main(String[] args) {
        /** часть 1.2
         * В методе main() Main класса создайте массив из 10 пользователей и заполните его объектами
         * и с помощью цикла выведите информацию только о пользователях старше 40 лет.
         */
        User[] users = {
                new User("Пупкин", "Василий", "Брониславович", 1990, "asd1@qwe.zxc"),
                new User("Пупкина", "Василиса", "Сигизмундовна", 1993, "asd2@qwe.zxc"),
                new User("Шварценгольд", "Фома", "Аристархович", 1920, "asd3@qwe.zxc"),
                new User("Моцарт", "Вольфганг", "Амадей", 1756, "asd4@qwe.zxc"),
                new User("Чайковский", "Петр", "Ильич", 1840, "asd5@qwe.zxc"),
                new User("Рахманинов", "Сергей", "Васильевич", 1873, "asd6@qwe.zxc"),
                new User("Глинка", "Михаил", "Иванович", 1804, "asd7@qwe.zxc"),
                new User("Шуберт", "Франц", "Петер", 1797, "asd8@qwe.zxc"),
                new User("Вивальди", "Антонио", "-", 1678, "asd9@qwe.zxc"),
                new User("Бетховен", "Людвиг ван", "-", 1770, "asd10@qwe.zxc")
        };
        int currentYear = Year.now().getValue();
        for (User user : users) {
            if ((currentYear - user.getBirthYear()) > 40) {
                user.printUserInfo();
            }
        }

        /** часть 2.2
         * Попробуйте реализовать класс по его описания: объекты класса Коробка должны иметь размеры и цвет. Коробку можно
         * открывать и закрывать. Коробку можно перекрашивать. Изменить размер коробки после создания нельзя. У коробки должен
         * быть метод, печатающий информацию о ней в консоль. В коробку можно складывать предмет (если в ней нет предмета),
         * или выкидывать его оттуда (только если предмет в ней есть), только при условии что коробка открыта
         * (предметом читаем просто строку). Выполнение методов должно сопровождаться выводом сообщений в консоль.
         */
        Box box = new Box(11, 12, 13, "Green", true);

        box.printBoxInfo();
        box.setColor("White");
        box.putEntity("Adapter");
        box.putEntity("Soap");
        box.closeBox();
        box.dropEntity();
        box.openBox();
        box.dropEntity();
        box.dropEntity();
        box.printBoxInfo();
    }
}
