package ru.otus.homeworks.lesson12;

public class Plate {
    private final int maxQuantity;
    private int currentQuantity;

    public Plate(int maxQuantity) {
        this.maxQuantity = maxQuantity;
        this.currentQuantity = maxQuantity;
    }

    public void addFood(int foodSize) {
        System.out.print("Попытка добавить " + foodSize + " еды в тарелку: ");
        if (currentQuantity == maxQuantity) {
            System.out.println("Тарелка полна, добавлять некуда");
            return;
        }
        if (foodSize > (maxQuantity - currentQuantity)) {
            System.out.println("В тарелку столько не влезет. Добавить можно лишь "
                    + (Math.abs(maxQuantity - currentQuantity)) + " единиц еды");
            return;
        }
        currentQuantity += foodSize;
        System.out.print("Тарелка пополнена. ");
        info();
    }

    public boolean reduceFood(int foodSize) {
        if ((currentQuantity - foodSize) < 0) {
            System.out.println("В тарелке нет нужного количества еды");
            return false;
        }
        currentQuantity -= foodSize;
        return true;
    }

    public void info() {
        System.out.println("В тарелке " + currentQuantity + " из " + maxQuantity + " единиц еды");
    }


}
