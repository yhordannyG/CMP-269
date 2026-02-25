
class BankAccount {

    private int balance = 1000;

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " withdrawing $" + amount);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance -= amount;
            System.out.println("Remaining balance: $" + balance);
        } else {
            System.out.println("Not enough money for " + Thread.currentThread().getName());
        }
    }
}

