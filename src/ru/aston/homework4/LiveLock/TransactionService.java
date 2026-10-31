package ru.aston.homework4.LiveLock;

public class TransactionService {
    private volatile boolean isWorkerActive = false;

    public void transfer(BankAccount from, BankAccount to, int amount) {
        String threadName = "[" + Thread.currentThread().getName() + "]";

        while (true) {
            if (from.tryLockAccount()) {
                try {
                    System.out.println(threadName + " Заблокировал свой счет: " + from.getOwnerName());

                    if (isWorkerActive) {
                        System.out.println(threadName + " Видит активность другого потока. ОТКАТ.");
                        continue;
                    }

                    isWorkerActive = true;

                    System.out.println(threadName + " Проверяет доступность счета получателя: " + to.getOwnerName() + "...");

                    if (to.tryLockAccount()) {
                        try {
                            from.withdraw(amount);
                            to.deposit(amount);

                            System.out.println(threadName + " Имитация операции завершена. Иду на новый круг уступок...");
                            isWorkerActive = false;
                        } finally {
                            to.unlockAccount();
                        }
                    } else {
                        System.out.println(threadName + " Счет " + to.getOwnerName() + " занят. ОТКАТ.");
                        isWorkerActive = false;
                    }

                } finally {
                    from.unlockAccount();
                }
            }

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
            }
        }
    }
}
