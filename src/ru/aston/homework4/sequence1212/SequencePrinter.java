package ru.aston.homework4.sequence1212;

public class SequencePrinter {
    private boolean isFirstTurn = true;

    public synchronized void print(int number) {
        while (true) {
            while ((number == 1 && !isFirstTurn) || (number == 2 && isFirstTurn)) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }

            System.out.println(number);

            isFirstTurn = !isFirstTurn;

            notifyAll();
        }
    }
}
