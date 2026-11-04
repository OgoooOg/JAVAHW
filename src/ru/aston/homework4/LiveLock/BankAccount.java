package ru.aston.homework4.LiveLock;

import java.math.BigDecimal;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private final String ownerName;
    private BigDecimal balance;
    private final Lock lock = new ReentrantLock();

    public BankAccount(String ownerName, BigDecimal initialBalance) {
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }

    public boolean tryLockAccount() {

        return lock.tryLock();
    }

    public void unlockAccount() {
        lock.unlock();
    }

    public void withdraw(BigDecimal amount) {
        if (balance.compareTo(amount) < 0) {
            throw new IllegalArgumentException("Недостаточно средств на счете " + ownerName);
        }
        this.balance = this.balance.subtract(amount);
    }

    public void deposit(BigDecimal amount) {

        this.balance = this.balance.add(amount);
    }

    public String getOwnerName() {
        return ownerName;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
