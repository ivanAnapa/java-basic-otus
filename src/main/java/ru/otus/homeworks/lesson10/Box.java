package ru.otus.homeworks.lesson10;

/** часть 2.1
 * Попробуйте реализовать класс по его описания:
 * - объекты класса Коробка должны иметь размеры и цвет.
 * - Коробку можно открывать и закрывать.
 * - Коробку можно перекрашивать.
 * - Изменить размер коробки после создания нельзя.
 * - У коробки должен быть метод, печатающий информацию о ней в консоль.
 * - В коробку можно складывать предмет (если в ней нет предмета), или выкидывать его оттуда (только если предмет
 *   в ней есть), только при условии что коробка открыта (предметом читаем просто строку).
 * - Выполнение методов должно сопровождаться выводом сообщений в консоль.
 */
public class Box {
    private int length;
    private int width;
    private int height;
    private String color;
    private boolean isOpened;
    private String entity;

    public Box(int length, int width, int height, String color, boolean isOpened) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.color = color;
        this.isOpened = isOpened;
    }

    public void openBox() {
        System.out.print("\nПопытка открыть коробку: ");
        if (!isOpened) {
            isOpened = true;
            System.out.println("Коробка успешно открыта");
        } else {
            System.out.println("Открывать коробку не требуется, тк она уже открыта");
        }
    }

    public void closeBox() {
        System.out.print("\nПопытка закрыть коробку: ");
        if (isOpened) {
            isOpened = false;
            System.out.println("Коробка успешно закрыта");
        } else {
            System.out.println("Закрывать коробку не требуется, тк она уже закрыта");
        }
    }

    public void setColor(String color) {
        System.out.println("\nПерекрашиваем коробку в " + color + " цвет");
        this.color = color;
    }

    public void printBoxInfo() {
        System.out.println("\nИнформация о коробке:");
        System.out.println(" - Размеры коробки: " + length + " Х " + width + " Х " + height);
        System.out.println(" - Цвет коробки: " + color);
        if (isOpened) {
            System.out.println(" - Коробка открыта");
        } else {
            System.out.println(" - Коробка закрыта");
        }
        if (entity == null) {
            System.out.println(" - Коробка пуста");
        } else {
            System.out.println(" - В коробке есть предмет: " + entity);
        }
    }

    public void putEntity(String newEntity) {
        System.out.print("\nПопытка положить в коробку предмет: ");
        if (!isOpened) {
            System.out.println("Положить предмет нельзя, тк коробка закрыта");
        } else {
            if (entity == null) {
                this.entity = newEntity;
                System.out.println("В коробку успешно добавлен предмет: " + newEntity);
            } else {
                System.out.println("Предмет в коробку добавить нельзя, тк она заполнена");
            }
        }
    }

    public void dropEntity() {
        System.out.print("\nПопытка выбросить предмет из коробки: ");
        if (!isOpened) {
            System.out.println("Выбросить предмет нельзя, тк коробка закрыта");
        } else {
            if (entity != null) {
                System.out.println("Из коробки успешно выброшен предмет - " + entity);
                this.entity = null;
            } else {
                System.out.println("Из коробки ничего нельзя выбросить, тк она пуста");
            }
        }
    }
}
