package ru.aston.homework4.sequence1212;

public class Main {
    public static void main(String[] args) {
        System.out.println("Старт поочередного вывода чисел...");

        SequencePrinter printer = new SequencePrinter();

        NumberThread task1 = new NumberThread(printer, 1);
        NumberThread task2 = new NumberThread(printer, 2);

        Thread thread1 = new Thread(task1, "Thread-1");
        Thread thread2 = new Thread(task2, "Thread-2");

        thread1.start();
        thread2.start();
    }
}
