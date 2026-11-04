package ru.aston.homework4.Sequence1212;

public class NumberThread implements Runnable {
    private final SequencePrinter printer;
    private final int numberToPrint;

    public NumberThread(SequencePrinter printer, int numberToPrint) {
        this.printer = printer;
        this.numberToPrint = numberToPrint;
    }

    @Override
    public void run() {
        printer.print(numberToPrint);
    }
}
