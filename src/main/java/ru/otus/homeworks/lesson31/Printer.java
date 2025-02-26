package ru.otus.homeworks.lesson31;

public class Printer {
    private final int numOfThreads;
    private int orderOfPrinting = 1;

    public Printer(int numOfThreads) {
        this.numOfThreads = numOfThreads;
    }

    public synchronized void print(String symbolForPrint, int currentThreadNumber) throws InterruptedException {

        while (orderOfPrinting != currentThreadNumber) {
            wait();
        }
        System.out.print(symbolForPrint);
        orderOfPrinting = (currentThreadNumber == numOfThreads)? 1 : (currentThreadNumber + 1);
        notifyAll();
    }
}
