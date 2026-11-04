package ru.aston.homework4.LiveLock;

import java.math.BigDecimal;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicBoolean;

public class TransactionService {
    private final CyclicBarrier barrier = new CyclicBarrier(2);
    private final AtomicBoolean isTransferring = new AtomicBoolean(false);

    public void transfer(BankAccount from, BankAccount to, BigDecimal amount) {
        String threadName = "[" + Thread.currentThread().getName() + "]";

        while (true) {
            if (from.tryLockAccount()) {
                try {
                    System.out.println(threadName + " Заблокировал свой счет: " + from.getOwnerName());

                    try {
                        barrier.await();
                    } catch (InterruptedException | BrokenBarrierException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }

                    if (isTransferring.compareAndSet(false, true)) {
                        System.out.println(threadName + " Проверяет доступность счета получателя: " + to.getOwnerName() + "...");

                        System.out.println(threadName + " Счет " + to.getOwnerName() + " занят. ОТКАТ.");

                        isTransferring.set(false);
                    } else {
                        System.out.println(threadName + " Счет " + to.getOwnerName() + " занят (видит активность). ОТКАТ.");
                    }

                } finally {
                    from.unlockAccount();
                }
            }

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}