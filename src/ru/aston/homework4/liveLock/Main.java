package ru.aston.homework4.liveLock;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        System.out.println("Банковская система запущена...");

        BankAccount accountIvan = new BankAccount("Иван", new BigDecimal("5000"));
        BankAccount accountAnna = new BankAccount("Анна", new BigDecimal("3000"));

        TransactionService service = new TransactionService();

        Thread ivanThread = new Thread(() -> {
            service.transfer(accountIvan, accountAnna, new BigDecimal("1000"));
        }, "Поток-1-IVAN");

        Thread annaThread = new Thread(() -> {
            service.transfer(accountAnna, accountIvan, new BigDecimal("500"));
        }, "Поток-2-ANNA");

        ivanThread.start();
        annaThread.start();
    }
}
