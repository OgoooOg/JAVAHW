package ru.aston.homework4.Sequence1212;

public class Main {
    public static void main(String[] args) {
        System.out.println("Старт поочередного вывода чисел...");

        SequencePrinter printer = new SequencePrinter();

        NumberThread thread1 = new NumberThread(printer, 1, "Thread-1");
        NumberThread thread2 = new NumberThread(printer, 2, "Thread-2");

        thread1.start();
        thread2.start();
    }
}
