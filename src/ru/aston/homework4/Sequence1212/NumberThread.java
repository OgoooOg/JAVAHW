package ru.aston.homework4.Sequence1212;

public class NumberThread extends Thread {
    private final SequencePrinter printer;
    private final int numberToPrint;

    public NumberThread(SequencePrinter printer, int numberToPrint, String name) {
        super(name);
        this.printer = printer;
        this.numberToPrint = numberToPrint;
    }

    @Override
    public void run() {
        if (numberToPrint == 1) {
            printer.printOne();
        } else if (numberToPrint == 2) {
            printer.printTwo();
        }
    }
}
