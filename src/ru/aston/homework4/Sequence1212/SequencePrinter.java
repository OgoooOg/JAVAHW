package ru.aston.homework4.Sequence1212;

public class SequencePrinter {
    private boolean isFirstTurn = true;

    public synchronized void printOne() {
        while (true) {
            while (!isFirstTurn) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }

            System.out.print("1 ");

            isFirstTurn = false;

            notifyAll();
        }
    }

    public synchronized void printTwo() {
        while (true) {
            while (isFirstTurn) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }

            System.out.print("2 ");

            isFirstTurn = true;

            notifyAll();
        }
    }
}
