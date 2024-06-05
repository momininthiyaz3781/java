package day23;

class BankAccount {
    private int balance = 0;

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited: " + amount + ", Balance: " + balance);
    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew: " + amount + ", Balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " attempted to withdraw: " + amount + ", Insufficient funds, Balance: " + balance);
        }
    }

    public int getBalance() {
        return balance;
    }
}

class Depositor implements Runnable {
    private final BankAccount account;

    public Depositor(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            account.deposit(100);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class Withdrawer implements Runnable {
    private final BankAccount account;

    public Withdrawer(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            account.withdraw(50);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class Task4 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        Thread t1 = new Thread(new Depositor(account), "Depositor-1");
        Thread t2 = new Thread(new Depositor(account), "Depositor-2");
        Thread t3 = new Thread(new Withdrawer(account), "Withdrawer-1");
        Thread t4 = new Thread(new Withdrawer(account), "Withdrawer-2");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Final Balance: " + account.getBalance());
    }
} 
