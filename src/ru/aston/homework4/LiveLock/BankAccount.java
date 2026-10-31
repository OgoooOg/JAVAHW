package ru.aston.homework4.LiveLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private final String ownerName;
    private int balance;
    private final Lock lock = new ReentrantLock();

    public BankAccount(String ownerName, int initialBalance) {
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }

    public boolean tryLockAccount() {
        return lock.tryLock();
    }

    public void unlockAccount() {
        lock.unlock();
    }

    public void withdraw(int amount) {
        this.balance -= amount;
    }

    public void deposit(int amount) {
        this.balance += amount;
    }

    public String getOwnerName() {
        return ownerName;
    }
}
