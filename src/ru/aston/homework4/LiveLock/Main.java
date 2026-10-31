package ru.aston.homework4.LiveLock;

public class Main {
    public static void main(String[] args) {
        System.out.println("Банковская система запущена...");

        BankAccount accountIvan = new BankAccount("Иван", 5000);
        BankAccount accountAnna = new BankAccount("Анна", 3000);

        TransactionService service = new TransactionService();

        Thread ivanThread = new Thread(() -> {
            service.transfer(accountIvan, accountAnna, 1000);
        }, "Поток-1-IVAN");

        Thread annaThread = new Thread(() -> {
            service.transfer(accountAnna, accountIvan, 500);
        }, "Поток-2-ANNA");

        ivanThread.start();
        annaThread.start();
    }
}
